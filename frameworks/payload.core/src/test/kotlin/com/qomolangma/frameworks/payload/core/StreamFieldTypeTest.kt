package com.qomolangma.frameworks.payload.core

import com.qomolangma.frameworks.payload.core.StringFieldType.Companion.asString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StreamFieldTypeTest {
    @Test
    fun should_be_able_to_convert_into_streams_from_array_lists() {
        assertThat(asString().stream().from(listOf("1", "2", "3"))).containsExactly("1", "2", "3")
    }

    @Test
    fun should_be_able_to_convert_into_streams_from_null_values() {
        assertThat(asString().stream().nullToEmpty().from(null)).containsExactly()
    }
}
