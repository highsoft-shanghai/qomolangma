package com.qomolangma.frameworks.payload.core

class IntFieldType : FieldType<Int>() {
    override fun match(underlyingType: Class<*>): Boolean {
        return Number::class.java.isAssignableFrom(underlyingType)
    }

    override fun convert(value: Any): Int {
        return (value as Number).toInt()
    }

    companion object {
        @JvmStatic
        fun asInt(): IntFieldType {
            return IntFieldType()
        }
    }
}
