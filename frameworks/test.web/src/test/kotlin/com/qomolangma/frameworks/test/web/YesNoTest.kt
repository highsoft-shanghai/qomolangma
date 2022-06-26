package com.qomolangma.frameworks.test.web

import com.qomolangma.frameworks.test.web.YesNo.Companion.of
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class YesNoTest {
    @Test
    fun should_format_true_as_yes() {
        assertThat(of(true).toString()).isEqualTo("Yes")
    }

    @Test
    fun should_format_false_as_no() {
        assertThat(of(false).toString()).isEqualTo("No")
    }
}
