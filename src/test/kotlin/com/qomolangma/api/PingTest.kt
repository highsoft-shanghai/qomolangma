package com.qomolangma.api

import com.qomolangma.frameworks.test.web.Documentation
import com.qomolangma.frameworks.test.web.IntegrationTest
import com.qomolangma.frameworks.test.web.PathVariables.Companion.variables
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.springframework.restdocs.payload.PayloadDocumentation.*

class PingTest : IntegrationTest() {
    @Test
    fun should_reply_pong() {

        val post = post("/ping", variables(HashMap<String, Any>()), mapOf(Pair("data", "pong")), documentation())
        post.statusCode(Matchers.`is`(200)).body("ping", Matchers.`is`("pong")).body("message", Matchers.`is`("ok"))
    }

    fun documentation(): Documentation {
        return Documentation.doc(
            "test.ping", requestFields(
                fieldWithPath("data").description("测试数据")
            ), responseFields(
                fieldWithPath("ping").description("ping"),
                fieldWithPath("message").description("message")
            )
        )
    }
}
