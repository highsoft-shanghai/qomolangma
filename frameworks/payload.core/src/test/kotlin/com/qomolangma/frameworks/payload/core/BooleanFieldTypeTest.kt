package com.qomolangma.frameworks.payload.core

import com.qomolangma.frameworks.payload.core.BooleanFieldType.Companion.asBoolean
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BooleanFieldTypeTest {
    @Test
    fun should_be_able_to_convert_into_booleans_from_boolean_values() {
        assertThat(asBoolean().from(true)).isEqualTo(true)
    }
}
