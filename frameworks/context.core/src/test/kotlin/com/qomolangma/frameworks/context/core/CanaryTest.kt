package com.qomolangma.frameworks.context.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CanaryTest {
    @Test
    fun should_be_able_to_run_tests() {
        assertThat("ok").isEqualTo("ok")
    }
}
