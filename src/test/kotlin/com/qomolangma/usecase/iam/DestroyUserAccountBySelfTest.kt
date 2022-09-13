package com.qomolangma.usecase.iam

import com.qomolangma.ApiTest
import com.qomolangma.frameworks.security.core.Authorities
import com.qomolangma.frameworks.test.web.Documentation
import com.qomolangma.frameworks.test.web.Documentation.Companion.doc
import com.qomolangma.frameworks.test.web.PathVariables.Companion.variables
import com.qomolangma.frameworks.test.web.WithGrantedAuthorities
import com.qomolangma.iam.domain.User
import com.qomolangma.iam.domain.Users
import com.qomolangma.usecase.iam.TestUsers.Companion.tester
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.responseFields
import java.util.*
import javax.annotation.Resource
import kotlin.test.assertSame

private val tester = tester(Authorities.AUTHENTICATED)

class DestroyUserAccountBySelfTest : ApiTest() {
    @Resource
    private val users: Users? = null

    @Resource
    private val accessTokens: User.AccessTokens? = null

    @Test
    @WithGrantedAuthorities([Authorities.AUTHENTICATED])
    internal fun should_destroy_one_account_by_self() {
        val user = users!!.getByName(tester.owner().user().name())
        delete("/user/me", variables(mapOf<String, String>()), document())
            .statusCode(`is`(200))
            .body("code", `is`("0"))
        assertSame(Optional.empty(), users.getByName(tester.owner().user().name()))
        assertSame(Optional.empty(), accessTokens!!.getById(user.get().id()))
    }

    @AfterEach
    internal fun tearDown() {
        users!!.clear()
        accessTokens!!.clear()
    }

    override fun document(): Documentation = doc(
        "iam.user.delete.me",
        responseFields(
            fieldWithPath("code").ignored(),
            fieldWithPath("msg").ignored(),
            fieldWithPath("data").ignored()
        )
    )
}
