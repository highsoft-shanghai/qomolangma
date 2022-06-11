package com.everest.frameworks.valueobjects.payload

class ObjectFieldType : FieldType<RequestPayload>() {
    fun nullToEmpty(): ObjectFieldType {
        setNullHandler { RequestPayload(emptyMap<Any, Any>()) }
        return this
    }

    override fun match(underlyingType: Class<*>): Boolean {
        return MutableMap::class.java.isAssignableFrom(underlyingType)
    }

    override fun convert(value: Any): RequestPayload {
        return RequestPayload(value)
    }

    companion object {
        @JvmStatic
        fun asObject(): ObjectFieldType {
            return ObjectFieldType()
        }
    }
}
