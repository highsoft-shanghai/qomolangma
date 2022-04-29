package com.example.frameworks.domain.core

@FunctionalInterface
interface SupplierWithCheckedException<T> {
    @Throws(Exception::class)
    fun get(): T?
}
