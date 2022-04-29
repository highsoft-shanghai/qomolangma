package com.example.frameworks.domain.core

class StringFieldType : FieldType<String?>() {
    fun nullToEmpty(): StringFieldType {
        setNullHandler { "" }
        return this
    }

    override fun match(underlyingType: Class<*>): Boolean {
        return String::class.java.isAssignableFrom(underlyingType)
    }

    override fun convert(value: Any): String {
        return value as String
    }

    companion object {
        @JvmStatic
        fun asString(): StringFieldType {
            return StringFieldType()
        }
    }
}
