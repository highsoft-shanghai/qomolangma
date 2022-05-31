package com.example.scaffold.frameworks.persistence.aggregates

import java.util.function.Function

class AggregatesResult<E, D, A>(private val data: E, private val asDomain: Function<D, A>) {
    fun self(): E {
        return data
    }

    fun domain(): A {
        return asDomain.apply(data as D)
    }
}
