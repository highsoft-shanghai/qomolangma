package com.qomolangma.frameworks.test.web

import org.hamcrest.Matchers
import org.junit.jupiter.api.Test

class RestTestTest : IntegrationTest() {
    @Test
    fun should_be_able_to_call_simple_get() {
        val response = get("/web-test/simple-get")
        response.statusCode(Matchers.`is`(200)).body("name", Matchers.`is`("John"))
    }
}
