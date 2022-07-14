package com.qomolangma.usecase.iam

import com.qomolangma.ApiTest
import com.qomolangma.frameworks.test.web.Documentation
import com.qomolangma.frameworks.test.web.Documentation.Companion.doc
import com.qomolangma.frameworks.test.web.PathVariables.Companion.variables
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test
import org.springframework.restdocs.payload.PayloadDocumentation
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.requestFields

class RegisterUserTest : ApiTest() {
    @Test
    internal fun should_register_user_successfully() {
        val post = post(
            "/user/register", variables(mapOf<String, Any>()), mapOf(
                Pair("userAccountName", "Qomolangma"),
                Pair("userName", "Neil"),
                Pair("tenantName", "qomolangma.com"),
                Pair("password", "123456"),
                Pair("confirmedPassword", "123456"),
                Pair("grantedAuthorities", listOf("admin"))
            ), document()
        )
        post.statusCode(`is`(200)).body("code", `is`("0"))
    }

    override fun document(): Documentation {
        return doc(
            "test.ping", requestFields(
                fieldWithPath("userAccountName").description("Account name of new user"),
                fieldWithPath("userName").description("Name of new user"),
                fieldWithPath("tenantName").description("Tenant name of new user"),
                fieldWithPath("grantedAuthorities").description("Authorities of new user"),
                fieldWithPath("password").description("Password of new user"),
                fieldWithPath("confirmedPassword").description("Password again of new user")
            ), PayloadDocumentation.responseFields(
                fieldWithPath("code").description("response code"),
                fieldWithPath("msg").description("response msg")
            )
        )

    }
}
