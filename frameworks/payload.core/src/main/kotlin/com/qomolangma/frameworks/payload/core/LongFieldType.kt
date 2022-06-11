package com.qomolangma.frameworks.payload.core

class LongFieldType : FieldType<Long>() {
    override fun match(underlyingType: Class<*>): Boolean {
        return Number::class.java.isAssignableFrom(underlyingType)
    }

    override fun convert(value: Any): Long {
        return (value as Number).toLong()
    }

    companion object {
        @JvmStatic
        fun asLong(): FieldType<Long> {
            return LongFieldType()
        }
    }
}
