package com.qomolangma.frameworks.payload.core

import com.qomolangma.frameworks.payload.core.InstantFieldType.Companion.asInstant
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.Instant

internal class InstantFieldTypeTest {
    @Test
    fun should_be_able_to_convert_into_instants_from_string_values() {
        assertThat(asInstant().from("2022-01-01T11:22:33Z")).isEqualTo(Instant.parse("2022-01-01T11:22:33Z"))
    }
}
