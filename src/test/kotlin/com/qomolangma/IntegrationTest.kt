package com.qomolangma

import com.qomolangma.frameworks.test.container.WithTestContainers
import com.qomolangma.frameworks.test.moco.MocoContainer
import com.qomolangma.frameworks.test.web.GlobalTestContext
import com.qomolangma.frameworks.test.web.Rest
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
    private val tokens: Users? = null
    private var user: User? = null

    protected fun removeAccessToken() {
        if (user != null) {
            tokens!!.remove(user!!)
        }
    }

    @BeforeEach
    fun setupAccessToken() {
        GlobalTestContext.context().ifPresent { context ->
            user = User.restore(
                context.securityContext().token(),
                UserIdentityOwner(context.userContext()),
                context.securityContext().grantedAuthorities()
            )
            tokens!!.save(user!!)
        }
    }

    @AfterEach
    fun teardownAccessToken() {
        removeAccessToken()
    }
}
