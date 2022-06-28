package com.qomolangma.frameworks.payload.core

import com.qomolangma.frameworks.payload.core.StringFieldType.Companion.asString
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test

internal class FieldFieldTypeTest {
    @Test
    fun should_be_able_to_convert_into_nulls_from_null_values() {
        assertThat(asString().allowNull().from(null)).isEqualTo(null)
    }

    @Test
    fun should_reject_type_mismatched_inputs() {
        val caught = catchThrowable { asString().from(1) }
        assertThat(caught).isInstanceOf(MalformedPayloadException::class.java)
        assertThat(caught).hasMessage("error.request.field-type-mismatch")
    }

    @Test
    fun should_reject_null_inputs() {
        val caught = catchThrowable { asString().from(null) }
        assertThat(caught).isInstanceOf(MalformedPayloadException::class.java)
        assertThat(caught).hasMessage("error.request.missing-field")
    }
}
