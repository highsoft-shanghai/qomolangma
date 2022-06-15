package com.qomolangma.config

import com.qomolangma.frameworks.test.web.IntegrationTest
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.nullValue
import org.junit.jupiter.api.Test

class ExceptionTranslationTest : IntegrationTest() {
    @Test
    fun should_be_able_to_translate_exception() {
        get("/test-not-found").statusCode(`is`(200)).body("code", `is`("1")).body("msg", `is`("nothing found"))
            .body("data", nullValue())
    }
}
