package com.qomolangma.usecase.iam

import com.qomolangma.ApiTest
import com.qomolangma.frameworks.test.web.Documentation
import com.qomolangma.frameworks.test.web.Documentation.Companion.doc
import com.qomolangma.frameworks.test.web.PathVariables.Companion.variables
import com.qomolangma.iam.domain.AccessToken
import com.qomolangma.iam.domain.User
import com.qomolangma.iam.domain.Users
import com.qomolangma.usecase.iam.TestUsers.Companion.system
import org.assertj.core.api.Assertions.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.restdocs.payload.PayloadDocumentation.*
import java.time.Instant
import javax.annotation.Resource

class UserLoginTest : ApiTest() {
    @Resource
    private val users: Users? = null

    @Resource
    private val accessTokens: User.AccessTokens? = null

    @BeforeEach
    internal fun setUp() {
        users!!.add(system())
        accessTokens!!.add(AccessToken(system().id(), "previous-token", Instant.now()))
        accessTokens.add(AccessToken(system().id(), "previous-token", Instant.now()))
        accessTokens.add(AccessToken("", "previous-token", Instant.now()))
    }

    @Test
    internal fun should_user_login_successfully() {
        val post = post(
            "/user/login", variables(mapOf<String, Any>()), mapOf(
                Pair("userName", "Neil"),
                Pair("password", "123456"),
            ), document()
        )
        val accessToken = system().displayAccessToken(accessTokens!!)
        assertThat(accessToken).isNotEqualTo("previous-token")
        post.statusCode(`is`(200))
            .body("code", `is`("0"))
            .body("data.token", `is`(accessToken))
        assertThat(system().displayAccessToken(accessTokens)).isNotEqualTo("")
    }

    @AfterEach
    internal fun tearDown() {
        users!!.clear()
        accessTokens!!.clear()
    }

    override fun document(): Documentation {
        return doc(
            "iam.user.login", requestFields(
                fieldWithPath("userName").description("Name of new user"),
                fieldWithPath("password").description("Password of new user"),
            ), responseFields(
                fieldWithPath("code").description("response code"),
                fieldWithPath("msg").description("response msg"),
                fieldWithPath("data.token").description("Token of this user")
            )
        )
    }
}
