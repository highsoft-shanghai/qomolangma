package com.example.frameworks.domain.core

import java.util.function.Function

interface Page<T> {
    fun content(): List<T>
    fun size(): Int
    fun number(): Int
    fun numberOfElements(): Int
    fun numberOfTotalPages(): Int
    fun numberOfTotalElements(): Long
    fun first(): Boolean
    fun last(): Boolean
    fun sort(): Sort
    fun <U> map(converter: Function<in T, out U>): Page<U>
}
