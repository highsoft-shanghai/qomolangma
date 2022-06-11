package com.qomolangma.frameworks.valueobjects.payload

import java.util.stream.Stream

class StreamFieldType<T>(private val elementType: FieldType<T>) : FieldType<Stream<T>>() {
    override fun match(underlyingType: Class<*>): Boolean {
        return MutableList::class.java.isAssignableFrom(underlyingType)
    }

    override fun convert(value: Any): Stream<T> {
        return (value as List<*>).stream().map(elementType::from)
    }

    fun nullToEmpty(): StreamFieldType<T> {
        setNullHandler { Stream.empty() }
        return this
    }
}
