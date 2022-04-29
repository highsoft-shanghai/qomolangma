package com.example.frameworks.domain.core

open class Value<T : Any>(value: T, fieldType: FieldType<T>) {
    private var value: T

    init {
        this.value = Payload(value).get(fieldType)
    }

    protected fun get(): T {
        return value
    }

    protected fun set(value: T) {
        this.value = value
    }
}
