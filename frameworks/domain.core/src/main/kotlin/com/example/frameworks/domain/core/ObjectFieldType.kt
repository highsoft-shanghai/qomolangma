package com.example.frameworks.domain.core

class ObjectFieldType : FieldType<Payload>() {
    fun nullToEmpty(): ObjectFieldType {
        setNullHandler { Payload(emptyMap<Any, Any>()) }
        return this
    }

    override fun match(underlyingType: Class<*>): Boolean {
        return MutableMap::class.java.isAssignableFrom(underlyingType)
    }

    override fun convert(value: Any): Payload {
        return Payload(value)
    }

    companion object {
        @JvmStatic
        fun asObject(): ObjectFieldType {
            return ObjectFieldType()
        }
    }
}
