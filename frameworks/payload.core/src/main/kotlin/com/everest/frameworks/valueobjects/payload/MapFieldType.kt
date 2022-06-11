package com.everest.frameworks.valueobjects.payload

class MapFieldType : FieldType<Map<*, *>>() {
    override fun match(underlyingType: Class<*>): Boolean {
        return MutableMap::class.java.isAssignableFrom(underlyingType)
    }

    override fun convert(value: Any): Map<*, *> {
        return value as Map<*, *>
    }

    companion object {
        @JvmStatic
        fun asMap(): FieldType<Map<*, *>> {
            return MapFieldType()
        }
    }
}
