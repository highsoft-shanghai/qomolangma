package com.qomolangma

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CanaryTest : IntegrationTest() {
    @Test
    fun should_be_able_to_run_spring_tests() {
        assertThat("Use-case test environment OK").isNotBlank
        QomolangmaApplication.main(arrayOf())
    }
}
