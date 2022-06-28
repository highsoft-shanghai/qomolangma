package com.qomolangma.frameworks.payload.core

import com.qomolangma.frameworks.payload.core.StringFieldType.Companion.asString
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test

internal class StringFieldTypeTest {
    @Test
    fun should_be_able_to_convert_into_strings_from_strings() {
        assertThat(asString().from("text")).isEqualTo("text")
    }

    @Test
    fun should_be_able_to_convert_into_strings_from_null_values() {
        assertThat(asString().nullToEmpty().from(null)).isEqualTo("")
    }

    @Test
    fun should_reject_type_mismatched_inputs() {
        val caught = catchThrowable { asString().from(1) }
        assertThat(caught).isInstanceOf(MalformedPayloadException::class.java)
        assertThat(caught).hasMessage("error.request.field-type-mismatch")
    }
}
