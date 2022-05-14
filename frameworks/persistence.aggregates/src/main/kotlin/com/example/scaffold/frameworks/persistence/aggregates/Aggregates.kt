package com.example.scaffold.frameworks.persistence.aggregates

import com.example.scaffold.frameworks.persistence.aggregates.AggregatesConsumers.*
import org.springframework.data.repository.Repository
import java.util.*
import java.util.function.Function

class Aggregates<A, D, R : Repository<D, ID>, ID>(
    private val repository: R,
    private val asData: Function<A, D>,
    private val asDomain: Function<D, A>
) {
    fun acceptByAggregate(consumer: Consumer1<D, ID, R, D>, aggregate: A) {
        this.accept(consumer, asData.apply(aggregate))
    }

    fun <P> accept(consumer: Consumer1<D, ID, R, P>, param: P) {
        consumer.accept(repository, param)
    }

    fun <P1, P2> accept(consumer: Consumer2<D, ID, R, P1, P2>, param1: P1, param2: P2) {
        consumer.accept(repository, param1, param2)
    }

    fun <P1, P2, P3> accept(consumer: Consumer3<D, ID, R, P1, P2, P3>, param1: P1, param2: P2, param3: P3) {
        consumer.accept(repository, param1, param2, param3)
    }

    fun <P> applyAsAggregate(function: AggregatesFunctions.Function1<D, ID, R, P, D>, param: P): A {
        return asDomain.apply(ensureExistence(apply(function, param)))
    }

    fun <P1, P2> applyAsAggregate(
        function: AggregatesFunctions.Function2<D, ID, R, P1, P2, D>,
        param1: P1,
        param2: P2
    ): A {
        return asDomain.apply(ensureExistence(apply(function, param1, param2)))
    }

    fun <P1, P2, P3> applyAsAggregate(
        function: AggregatesFunctions.Function3<D, ID, R, P1, P2, P3, D>,
        param1: P1,
        param2: P2,
        param3: P3
    ): A {
        return asDomain.apply(ensureExistence(apply(function, param1, param2, param3)))
    }

    fun <P, E> apply(function: AggregatesFunctions.Function1<D, ID, R, P, E>, param: P): E {
        return function.apply(repository, param)
    }

    fun <P1, P2, E> apply(function: AggregatesFunctions.Function2<D, ID, R, P1, P2, E>, param1: P1, param2: P2): E {
        return function.apply(repository, param1, param2)
    }

    fun <P1, P2, P3, E> apply(
        function: AggregatesFunctions.Function3<D, ID, R, P1, P2, P3, E>,
        param1: P1,
        param2: P2,
        param3: P3
    ): E {
        return function.apply(repository, param1, param2, param3)
    }

    private fun ensureExistence(data: D): D {
        return Optional.ofNullable(data).orElseThrow { RuntimeException("error.can-not-get-aggregate") }
    }
}
