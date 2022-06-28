package com.qomolangma.frameworks.payload.core

import com.qomolangma.frameworks.payload.core.DoubleFieldType.Companion.asDouble
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DoubleFieldTypeTest {
    @Test
    fun should_be_able_to_convert_into_doubles_from_doubles() {
        assertThat(asDouble().from(1.3)).isEqualTo(1.3)
    }
}
