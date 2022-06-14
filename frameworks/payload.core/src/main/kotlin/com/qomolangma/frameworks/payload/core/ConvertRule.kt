package com.qomolangma.frameworks.payload.core

import java.util.function.Function

class ConvertRule<D> private constructor(private val name: String, private val function: Function<D, Any>) {
    fun apply(d: D): Any {
        return function.apply(d)
    }

    fun name(): String {
        return name
    }

    companion object {
        @JvmStatic
        fun <D> rule(name: String, function: Function<D, Any>): ConvertRule<D> {
            return ConvertRule(name, function)
        }
    }
}
