package com.qomolangma.frameworks.payload.core

import com.qomolangma.frameworks.payload.core.StringFieldType.Companion.asString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ArrayFieldTypeTest {
    @Test
    fun should_be_able_to_convert_into_lists_from_array_lists() {
        assertThat(asString().array().from(listOf("1", "2", "3"))).isEqualTo(listOf("1", "2", "3"))
    }

    @Test
    fun should_be_able_to_convert_into_lists_from_null_values() {
        assertThat(asString().array().nullToEmpty().from(null)).isEqualTo(listOf<Any>())
    }
}
