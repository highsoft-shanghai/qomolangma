package com.example.frameworks.domain.core

import java.util.function.Function

class EmptyPage<T> : Page<T> {
    override val content: List<T>
    override val totalElements: Long
    override val size: Int
    override val number: Int
    override val numberOfElements: Int

    init {
        content = ArrayList()
        totalElements = 0
        size = 0
        number = 0
        numberOfElements = 0
    }

    fun of(): EmptyPage<T> {
        return EmptyPage()
    }

    override fun <U> map(converter: Function<in T, out U>?): Page<U>? {
        return EmptyPage()
    }
}
