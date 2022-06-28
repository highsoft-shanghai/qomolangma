package com.qomolangma.frameworks.payload.core

import com.qomolangma.frameworks.payload.core.MapFieldType.Companion.asMap
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MapFieldTypeTest {
    @Test
    fun should_be_able_to_convert_into_maps_from_maps() {
        assertThat(asMap().from(mapOf(Pair("a", "b")))).isEqualTo(mapOf(Pair("a", "b")))
    }
}
