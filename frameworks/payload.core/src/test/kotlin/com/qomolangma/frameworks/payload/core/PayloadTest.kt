package com.qomolangma.frameworks.payload.core

import com.qomolangma.frameworks.payload.core.ObjectFieldType.Companion.asObject
import com.qomolangma.frameworks.payload.core.StringFieldType.Companion.asString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PayloadTest {
    @Test
    fun should_be_able_to_convert_typed_values() {
        val payload = Payload("a text")
        assertThat(payload[asString()]).isEqualTo("a text")
    }

    @Test
    fun should_be_able_to_read_typed_fields() {
        val payload = Payload(mapOf(Pair("name", "John")))
        assertThat(payload["name", asString()]).isEqualTo("John")
    }

    @Test
    fun should_be_able_to_read_object_fields() {
        val payload = Payload(mapOf(Pair("nested", mapOf(Pair("name", "John")))))
        assertThat(payload["nested", asObject()]["name", asString()]).isEqualTo("John")
    }

    @Test
    fun should_be_able_to_read_objects_from_null_fields() {
        val payload = Payload(mapOf<Any, Any>())
        assertThat(payload["nested", asObject().nullToEmpty()]["name", asString().allowNull()])
            .isEqualTo(null)
    }
}
