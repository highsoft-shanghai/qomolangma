package com.qomolangma.frameworks.payload.core

import com.qomolangma.frameworks.payload.core.DecimalFieldType.Companion.asDecimal
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class DecimalFieldTypeTest {
    @Test
    fun should_be_able_to_convert_into_decimals_from_number_values() {
        assertThat(asDecimal().from(13.5)).isEqualTo(BigDecimal("13.5"))
    }

    @Test
    fun should_be_able_to_convert_into_decimals_from_string_values() {
        assertThat(asDecimal().from("13.5")).isEqualTo(BigDecimal("13.5"))
    }

    @Test
    fun should_reject_values_with_wrong_type() {
        Assertions.assertThatThrownBy { asDecimal().from(true) }.isInstanceOf(
            MalformedPayloadException::class.java
        )
    }
}
