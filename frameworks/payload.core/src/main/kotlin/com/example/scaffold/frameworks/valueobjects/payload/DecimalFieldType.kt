package com.example.scaffold.frameworks.valueobjects.payload

import java.math.BigDecimal

class DecimalFieldType : FieldType<BigDecimal>() {
    override fun match(underlyingType: Class<*>): Boolean {
        return Number::class.java.isAssignableFrom(underlyingType) || String::class.java.isAssignableFrom(underlyingType)
    }

    override fun convert(value: Any): BigDecimal {
        return if (Number::class.java.isAssignableFrom(value.javaClass)) BigDecimal.valueOf((value as Number).toDouble())
        else BigDecimal(value as String)
    }

    companion object {
        @JvmStatic
        fun asDecimal(): DecimalFieldType {
            return DecimalFieldType()
        }
    }
}
