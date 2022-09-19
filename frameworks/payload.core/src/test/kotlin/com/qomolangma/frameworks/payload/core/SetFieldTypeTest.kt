package com.qomolangma.frameworks.payload.core

import com.qomolangma.frameworks.payload.core.StringFieldType.Companion.asString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SetFieldTypeTest {
    @Test
    fun should_be_able_to_convert_into_sets_from_sets() {
        assertThat(asString().set().nullToEmpty().from(setOf("a", "b"))).isEqualTo(setOf("a", "b"))
    }

    @Test
    fun should_not_set_match_string() {
        assertThat(asString().set().match(String.Companion::class.java)).isEqualTo(false)
    }
}
