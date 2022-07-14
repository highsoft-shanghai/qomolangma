package com.qomolangma.infra

import com.qomolangma.ApiTest
import com.qomolangma.frameworks.test.web.Documentation
import com.qomolangma.frameworks.test.web.PathVariables.Companion.variables
import com.qomolangma.frameworks.test.web.WithGrantedAuthorities
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test
import org.springframework.restdocs.payload.PayloadDocumentation.*

class PingTest : ApiTest() {
    @Test
    @WithGrantedAuthorities(["grantedAuthority"])
    fun should_reply_pong() {
        val post = post("/ping", variables(HashMap<String, Any>()), mapOf(Pair("data", "pong")), document())
        post.statusCode(`is`(200)).body("data.ping", `is`("pong")).body("data.message", `is`("ok"))
    }

    override fun document(): Documentation {
        return Documentation.doc(
            "test.ping", requestFields(
                fieldWithPath("data").description("Test data")
            ), responseFields(
                fieldWithPath("code").description("response code"),
                fieldWithPath("msg").description("response msg"),
                fieldWithPath("data").description("response data"),
                fieldWithPath("data.ping").ignored(),
                fieldWithPath("data.message").ignored()
            )
        )
    }
}
