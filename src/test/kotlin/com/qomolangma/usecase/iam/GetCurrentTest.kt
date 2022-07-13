package com.qomolangma.usecase.iam

import com.qomolangma.ApiTest
import com.qomolangma.frameworks.test.web.Documentation
import com.qomolangma.frameworks.test.web.Documentation.Companion.doc
import com.qomolangma.frameworks.test.web.WithGrantedAuthorities
import org.hamcrest.Matchers.contains
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.responseFields

class GetCurrentTest : ApiTest() {
    @Test
    @WithGrantedAuthorities(["grantedAuthority"])
    fun should_report_error_info_correctly() {
        removeAccessToken()
        val response = get("/access-tokens/current", document())
        response.statusCode(`is`(200))
            .body("code", `is`("0"))
            .body("msg", `is`(""))
            .body("data.accessToken", `is`("id"))
            .body("data.authorities", contains("grantedAuthority"))
    }

    override fun document(): Documentation {
        return doc(
            "iam.access-tokens-current",
            responseFields(
                fieldWithPath("code").description("response code"),
                fieldWithPath("msg").description("response msg"),
                fieldWithPath("data.accessToken").description("Access token of current user"),
                fieldWithPath("data.authorities").description("Authorities of current user")
            )
        )
    }
}
