package com.qomolangma.frameworks.test.security

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class CanaryTest {
    @Test
    fun should_be_able_to_run_tests() {
        Assertions.assertThat("ok").isEqualTo("ok")
    }
}
