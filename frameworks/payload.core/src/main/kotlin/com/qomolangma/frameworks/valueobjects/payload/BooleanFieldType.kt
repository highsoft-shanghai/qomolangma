package com.qomolangma.frameworks.valueobjects.payload

class BooleanFieldType : FieldType<Boolean>() {
    override fun match(underlyingType: Class<*>): Boolean {
        return java.lang.Boolean::class.java.isAssignableFrom(underlyingType)
    }

    override fun convert(value: Any): Boolean {
        return value as Boolean
    }

    companion object {
        @JvmStatic
        fun asBoolean(): BooleanFieldType {
            return BooleanFieldType()
        }
    }
}
