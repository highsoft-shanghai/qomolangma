package com.everest.frameworks.valueobjects.payload

class DoubleFieldType : FieldType<Double>() {
    override fun match(underlyingType: Class<*>): Boolean {
        return Number::class.java.isAssignableFrom(underlyingType)
    }

    override fun convert(value: Any): Double {
        return (value as Number).toDouble()
    }

    companion object {
        @JvmStatic
        fun asDouble(): FieldType<Double> {
            return DoubleFieldType()
        }
    }
}
