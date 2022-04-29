package com.example.frameworks.domain.core

import com.example.frameworks.domain.core.MapFieldType.asMap

class Payload(private val value: Any) {
    fun <T> get(type: FieldType<T>): T {
        return type.from(value)
    }

    fun <T> get(key: String, type: FieldType<T>): T {
        return type.from(get(asMap())[key]);
    }
}
