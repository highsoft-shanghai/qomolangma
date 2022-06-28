package com.qomolangma.frameworks.payload.core

import com.qomolangma.frameworks.payload.core.LongFieldType.Companion.asLong
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LongFieldTypeTest {
    @Test
    fun should_be_able_to_convert_into_long_integers_from_long_integers() {
        assertThat(asLong().from(1L)).isEqualTo(1L)
    }
}
