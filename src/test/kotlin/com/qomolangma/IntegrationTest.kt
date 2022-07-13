package com.qomolangma

import com.qomolangma.frameworks.test.container.WithTestContainers
import com.qomolangma.frameworks.test.moco.MocoContainer
import com.qomolangma.frameworks.test.web.GlobalTestContext
import com.qomolangma.frameworks.test.web.Rest
import com.qomolangma.iam.domain.AccessToken
import com.qomolangma.iam.domain.AccessTokenOwner
import com.qomolangma.iam.domain.AccessTokens
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
    private val tokens: AccessTokens? = null
    private var accessToken: AccessToken? = null

    protected fun removeAccessToken() {
        if (accessToken != null) {
            tokens!!.remove(accessToken!!)
        }
    }

    @BeforeEach
    fun setupAccessToken() {
        GlobalTestContext.context().ifPresent { context ->
            accessToken = AccessToken.restore(
                context.securityContext().token(),
                AccessTokenOwner(context.userContext()),
                context.securityContext().grantedAuthorities()
            )
            tokens!!.save(accessToken!!)
        }
    }

    @AfterEach
    fun teardownAccessToken() {
        removeAccessToken()
    }
}
