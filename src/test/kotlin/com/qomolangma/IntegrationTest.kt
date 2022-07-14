package com.qomolangma

import com.qomolangma.frameworks.domain.core.GlobalClock
import com.qomolangma.frameworks.test.container.WithTestContainers
import com.qomolangma.frameworks.test.moco.MocoContainer
import com.qomolangma.frameworks.test.web.GlobalTestContext
import com.qomolangma.frameworks.test.web.Rest
import com.qomolangma.iam.domain.AccessToken
import com.qomolangma.iam.domain.User
import com.qomolangma.iam.domain.UserIdentityOwner
import com.qomolangma.iam.domain.Users
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import javax.annotation.Resource

@ActiveProfiles("unittest")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WithTestContainers(containers = [MocoContainer::class])
abstract class IntegrationTest : Rest() {
    @Resource
    private val users: Users? = null

    @Resource
    private val accessTokens: User.AccessTokens? = null
    private var user: User? = null
    private var accessToken: AccessToken? = null

    protected fun removeAccessToken() {
        users!!.clear()
        accessTokens!!.clear()
    }

    @BeforeEach
    fun setupAccessToken() {
        GlobalTestContext.context().ifPresent { context ->
            user = User.create(
                UserIdentityOwner(context.userContext()),
                context.securityContext().grantedAuthorities()
            )
            accessToken = AccessToken(
                user!!.id(),
                context.securityContext().id(),
                GlobalClock.now()
            )
            accessTokens!!.add(accessToken!!)
            users!!.add(user!!)
        }
    }

    @AfterEach
    fun teardownAccessToken() {
        removeAccessToken()
    }
}
