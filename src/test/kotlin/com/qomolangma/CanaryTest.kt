package com.qomolangma

import com.qomolangma.frameworks.test.web.IntegrationTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CanaryTest : IntegrationTest() {
    @Test
    fun should_be_able_to_run_spring_tests() {
        Assertions.assertThat("Use-case test environment OK").isNotBlank
    }
}
