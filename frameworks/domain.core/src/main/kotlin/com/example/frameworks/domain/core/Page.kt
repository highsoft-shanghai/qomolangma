package com.example.frameworks.domain.core

import java.util.function.Function

interface Page<T> {
    val content: List<T>?
    val totalElements: Long
    val size: Int
    val number: Int
    val numberOfElements: Int
    fun <U> map(converter: Function<in T, out U>?): Page<U>?
}
