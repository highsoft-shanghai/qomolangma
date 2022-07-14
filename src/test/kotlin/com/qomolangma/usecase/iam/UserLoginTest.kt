package com.qomolangma.usecase.iam

import com.qomolangma.ApiTest
import com.qomolangma.frameworks.domain.core.Identity
import com.qomolangma.frameworks.security.core.GrantedAuthorities
import com.qomolangma.frameworks.test.web.Documentation
import com.qomolangma.frameworks.test.web.Documentation.Companion.doc
import com.qomolangma.frameworks.test.web.PathVariables.Companion.variables
import com.qomolangma.iam.domain.AccessToken
import com.qomolangma.iam.domain.User
import com.qomolangma.iam.domain.UserIdentityOwner
import com.qomolangma.iam.domain.Users
import org.assertj.core.api.Assertions.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.restdocs.payload.PayloadDocumentation
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.requestFields
import java.util.*
import javax.annotation.Resource

class UserLoginTest : ApiTest() {
    @Resource
    private val users: Users? = null

    @Resource
    private val accessTokens: User.AccessTokens? = null
    private val user = User.restore(
        "1234",
        UserIdentityOwner.create(Identity.create(""), Identity.create("Neil"), Identity.create(""), "123456"),
        GrantedAuthorities.of("system")
    )

    @BeforeEach
    internal fun setUp() {
        users!!.add(user)
    }

    @Test
    internal fun should_user_login_successfully() {
        val post = post(
            "/user/login", variables(mapOf<String, Any>()), mapOf(
                Pair("userName", "Neil"),
                Pair("password", "123456"),
            ), document()
        )
        post.statusCode(`is`(200))
            .body("code", `is`("0"))
            .body("data.token", `is`(user.accessToken(accessTokens!!)))
        assertThat(user.accessToken(accessTokens)).isNotEqualTo(Optional.empty<AccessToken>())
    }

    @AfterEach
    internal fun tearDown() {
    }

    override fun document(): Documentation {
        return doc(
            "iam.user.login", requestFields(
                fieldWithPath("userName").description("Name of new user"),
                fieldWithPath("password").description("Password of new user"),
            ), PayloadDocumentation.responseFields(
                fieldWithPath("code").description("response code"),
                fieldWithPath("msg").description("response msg"),
                fieldWithPath("data.token").description("Token of this user")
            )
        )
    }
}
