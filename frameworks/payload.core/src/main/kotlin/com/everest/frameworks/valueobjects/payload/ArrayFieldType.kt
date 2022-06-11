package com.everest.frameworks.valueobjects.payload

import java.util.stream.Collectors

class ArrayFieldType<T>(private val elementType: FieldType<T>) : FieldType<List<T>>() {
    fun nullToEmpty(): ArrayFieldType<T> {
        setNullHandler { emptyList() }
        return this
    }

    override fun match(underlyingType: Class<*>): Boolean {
        return MutableList::class.java.isAssignableFrom(underlyingType)
    }

    override fun convert(value: Any): List<T> {
        return (value as List<*>).stream().map(elementType::from).collect(Collectors.toList())
    }
}
