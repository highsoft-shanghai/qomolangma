package com.qomolangma.frameworks.test.moco

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

internal class CanaryTest {
    @Test
    fun should_be_able_to_run_tests() {
        assertThat("ok").isEqualTo("ok")
    }
}
