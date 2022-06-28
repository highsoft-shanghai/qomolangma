package com.qomolangma.frameworks.payload.core

import com.qomolangma.frameworks.payload.core.FloatFieldType.Companion.asFloat
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FloatTypeTest {
    @Test
    fun should_be_able_to_convert_into_floats_from_floats() {
        assertThat(asFloat().from(1.3f)).isEqualTo(1.3f)
    }
}
