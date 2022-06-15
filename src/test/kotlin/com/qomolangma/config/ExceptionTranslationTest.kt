package com.qomolangma.config

import com.qomolangma.frameworks.test.web.IntegrationTest
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test

class ExceptionTranslationTest : IntegrationTest() {
    @Test
    fun should_be_able_to_translate_exception() {
        get("/test-not-found").statusCode(Matchers.`is`(404))
    }
}
