package com.qomolangma.infra

import com.qomolangma.ApiTest
import com.qomolangma.frameworks.test.web.Documentation
import com.qomolangma.frameworks.test.web.Documentation.Companion.doc
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.nullValue
import org.junit.jupiter.api.Test
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.responseFields

class PathNotFoundTest : ApiTest() {
    @Test
    internal fun should_return_not_found_when_path_not_found() {
        get("/---path-not-found---", document())
            .statusCode(`is`(200))
            .body("code", `is`("1"))
            .body("msg", `is`("Not Found"))
            .body("data", nullValue())
    }

    override fun document(): Documentation = doc(
        "test.not.found", responseFields(
            fieldWithPath("code").description("Code"),
            fieldWithPath("msg").description("error msg"),
            fieldWithPath("data").ignored()
        )
    )
}
