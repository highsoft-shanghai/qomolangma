package com.qomolangma.frameworks.payload.core

import com.qomolangma.frameworks.payload.core.ObjectFieldType.Companion.asObject
import com.qomolangma.frameworks.payload.core.StringFieldType.Companion.asString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ObjectFieldTypeTest {
    @Test
    fun should_be_able_to_convert_into_objects_from_maps() {
        assertThat(asObject().from(mapOf(Pair("a", "b")))["a", asString()]).isEqualTo("b")
    }

    @Test
    fun should_be_able_to_convert_into_objects_from_null_values() {
        assertThat(asObject().nullToEmpty().from(null)["a", asString().allowNull()]).isEqualTo(null)
    }
}
