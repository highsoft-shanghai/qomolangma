package com.everest.frameworks.valueobjects.payload

class FloatFieldType : FieldType<Float>() {
    override fun match(underlyingType: Class<*>): Boolean {
        return Number::class.java.isAssignableFrom(underlyingType)
    }

    override fun convert(value: Any): Float {
        return (value as Number).toFloat()
    }

    companion object {
        @JvmStatic
        fun asFloat(): FieldType<Float> {
            return FloatFieldType()
        }
    }
}
