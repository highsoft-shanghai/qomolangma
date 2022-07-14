package com.qomolangma.infra

import com.qomolangma.ApiTest
import com.qomolangma.frameworks.test.web.Documentation
import com.qomolangma.frameworks.test.web.PathVariables.Companion.variables
import com.qomolangma.frameworks.test.web.WithGrantedAuthorities
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.nullValue
import org.junit.jupiter.api.Test
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.responseFields

class ExceptionRequestTest : ApiTest() {
    @Test
    @WithGrantedAuthorities(["f1"])
    fun should_reply_error() {
        val post = post("/exception-request", variables(HashMap<String, Any>()), HashMap<String, Any>(), document())
        post.statusCode(`is`(200)).body("code", `is`("1")).body("msg", `is`("Translated error message."))
            .body("data", nullValue())
    }

    override fun document(): Documentation {
        return Documentation.doc(
            "test.exception", responseFields(
                fieldWithPath("data").description("Empty"),
                fieldWithPath("code").description("response error code"),
                fieldWithPath("msg").description("response error msg")
            )
        )
    }
}
