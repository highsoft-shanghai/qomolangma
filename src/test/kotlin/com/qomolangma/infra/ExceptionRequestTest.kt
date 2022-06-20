package com.qomolangma.infra

import com.qomolangma.frameworks.test.web.ApiTest
import com.qomolangma.frameworks.test.web.Documentation
import com.qomolangma.frameworks.test.web.PathVariables.Companion.variables
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.nullValue
import org.junit.jupiter.api.Test
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.responseFields

class ExceptionRequestTest : ApiTest() {
    @Test
    fun should_reply_error() {
        val post =
            post("/exception-request", variables(HashMap<String, Any>()), HashMap<String, Any>(), documentation())
        post.statusCode(`is`(200)).body("code", `is`("1")).body("msg", `is`("Translated error message."))
            .body("data", nullValue())
    }

    override fun documentation(): Documentation {
        return Documentation.doc(
            "test.exception", responseFields(
                fieldWithPath("data").description("Empty"),
                fieldWithPath("code").description("response error code"),
                fieldWithPath("msg").description("response error msg")
            )
        )
    }
}
