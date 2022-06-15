package com.qomolangma.infra

import com.qomolangma.frameworks.test.web.Documentation
import com.qomolangma.frameworks.test.web.IntegrationTest
import com.qomolangma.frameworks.test.web.PathVariables.Companion.variables
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test
import org.springframework.restdocs.payload.PayloadDocumentation.*

class ExceptionRequestTest : IntegrationTest() {
    @Test
    fun should_reply_error() {
        val post =
            post("/exception-request", variables(HashMap<String, Any>()), HashMap<String, Any>(), documentation())
        post.statusCode(`is`(200)).body("code", `is`("1")).body("msg", `is`("Translated error message."))
            .body("data", nullValue())
    }

    fun documentation(): Documentation {
        return Documentation.doc(
            "test.exception", responseFields(
                fieldWithPath("data").description("Empty"),
                fieldWithPath("code").description("response error code"),
                fieldWithPath("msg").description("response error msg")
            )
        )
    }
}
