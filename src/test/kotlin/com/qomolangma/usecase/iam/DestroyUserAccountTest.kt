package com.qomolangma.usecase.iam

import com.qomolangma.ApiTest
import com.qomolangma.frameworks.security.core.Authorities
import com.qomolangma.frameworks.test.web.Documentation
import com.qomolangma.frameworks.test.web.Documentation.Companion.doc
import com.qomolangma.frameworks.test.web.PathVariables.Companion.variables
import com.qomolangma.frameworks.test.web.WithGrantedAuthorities
import com.qomolangma.iam.domain.AccessToken
import com.qomolangma.iam.domain.TokenGenerator
import com.qomolangma.iam.domain.User
import com.qomolangma.iam.domain.Users
import com.qomolangma.usecase.iam.TestUsers.Companion.common
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.responseFields
import org.springframework.restdocs.request.RequestDocumentation.parameterWithName
import org.springframework.restdocs.request.RequestDocumentation.pathParameters
import java.util.*
import javax.annotation.Resource
import kotlin.test.assertSame

class DestroyUserAccountTest : ApiTest() {
    @Resource
    private val users: Users? = null

    @Resource
    private val accessTokens: User.AccessTokens? = null

    @Resource
    private val tokenGenerator: TokenGenerator? = null

    @BeforeEach
    internal fun setUp() {
        users!!.add(common())
        accessTokens!!.add(AccessToken.create(common(), tokenGenerator))
    }

    @Test
    @WithGrantedAuthorities([Authorities.ADMIN])
    internal fun should_destroy_one_account_by_system_or_admin() {
        delete("/user/{id}", variables(mapOf(Pair("id", "1234"))), document())
            .statusCode(`is`(200))
            .body("code", `is`("0"))
        assertSame(Optional.empty(), users!!["1234"])
        assertSame(Optional.empty(), accessTokens!!["1234"])
    }

    @AfterEach
    internal fun tearDown() {
        users!!.clear()
        accessTokens!!.clear()
    }

    override fun document(): Documentation = doc(
        "iam.user.delete",
        pathParameters(
            parameterWithName("id").description("User id")
        ), responseFields(
            fieldWithPath("code").ignored(),
            fieldWithPath("msg").ignored(),
            fieldWithPath("data").ignored()
        )
    )
}
