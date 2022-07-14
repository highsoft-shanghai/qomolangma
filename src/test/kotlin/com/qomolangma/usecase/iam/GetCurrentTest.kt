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
        val response = get("/access-tokens/current", document())
        response.statusCode(`is`(200))
            .body("code", `is`("0"))
            .body("msg", `is`(""))
            .body("data.accessToken", `is`("Bearer tester-token-id"))
            .body("data.userAccountName", `is`("Qomolangma"))
            .body("data.tenantName", `is`("Qomolangma"))
            .body("data.userName", `is`("Tester"))
            .body("data.authorities", contains("grantedAuthority"))
    }

    override fun document(): Documentation {
        return doc(
            "iam.access-tokens-current",
            responseFields(
                fieldWithPath("code").description("response code"),
                fieldWithPath("msg").description("response msg"),
                fieldWithPath("data.id").description("Id of current user"),
                fieldWithPath("data.userAccountName").description("User account name of current user"),
                fieldWithPath("data.userName").description("Username of current user"),
                fieldWithPath("data.tenantName").description("Tenant name of current user"),
                fieldWithPath("data.accessToken").description("Access token of current user"),
                fieldWithPath("data.authorities").description("Authorities of current user")
            )
        )
    }
}
