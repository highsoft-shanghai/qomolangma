package com.example.scaffold.frameworks.valueobjects.payload

import java.time.Instant

class InstantFieldType : FieldType<Instant>() {
    override fun match(underlyingType: Class<*>): Boolean {
        return String::class.java.isAssignableFrom(underlyingType)
    }

    override fun convert(value: Any): Instant {
        return Instant.parse(value as String)
    }

    companion object {
        @JvmStatic
        fun asInstant(): InstantFieldType {
            return InstantFieldType()
        }
    }
}
