package com.qomolangma.frameworks.valueobjects.payload

import com.qomolangma.frameworks.valueobjects.payload.MapFieldType.Companion.asMap

class RequestPayload(private val value: Any?) {
    fun <T> get(type: FieldType<T>): T {
        return type.from(value)
    }

    fun <T> get(key: String, type: FieldType<T>): T {
        return type.from(get(asMap())[key]);
    }
}
