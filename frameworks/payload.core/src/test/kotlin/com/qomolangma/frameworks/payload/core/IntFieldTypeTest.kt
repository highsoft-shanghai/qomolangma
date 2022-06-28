package com.qomolangma.frameworks.payload.core

import com.qomolangma.frameworks.payload.core.IntFieldType.Companion.asInt
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class IntFieldTypeTest {
    @Test
    fun should_be_able_to_convert_into_integers_from_integers() {
        assertThat(asInt().from(1)).isEqualTo(1)
    }
}
