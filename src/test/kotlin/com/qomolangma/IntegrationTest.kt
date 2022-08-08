package com.qomolangma

import com.qomolangma.frameworks.domain.core.GlobalClock
import com.qomolangma.frameworks.test.container.WithTestContainers
import com.qomolangma.frameworks.test.moco.MocoContainer
import com.qomolangma.frameworks.test.web.GlobalTestContext
import com.qomolangma.frameworks.test.web.Rest
import com.qomolangma.frameworks.security.core.AccessToken
import com.qomolangma.frameworks.security.core.User
import com.qomolangma.frameworks.security.core.UserIdentityOwner
import com.qomolangma.frameworks.security.core.Users
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
        GlobalTestContext.context().ifPresent {
            user = User.create(
                UserIdentityOwner(it.userContext()),
                it.securityContext().grantedAuthorities()
            )
            accessToken = AccessToken(
                user!!.id(),
                it.securityContext().id(),
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
