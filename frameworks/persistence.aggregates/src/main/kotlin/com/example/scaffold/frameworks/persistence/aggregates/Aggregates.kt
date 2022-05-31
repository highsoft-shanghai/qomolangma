package com.example.scaffold.frameworks.persistence.aggregates

import com.example.scaffold.frameworks.persistence.aggregates.AggregatesConsumers.*
import com.example.scaffold.frameworks.persistence.aggregates.AggregatesFunctions.*
import org.springframework.data.repository.Repository
import java.util.*
import java.util.function.Function
import java.util.stream.Collectors

class Aggregates<A, D, R : Repository<D, ID>, ID>(
    private val repository: R,
    private val asData: Function<A, D>,
    private val asDomain: Function<D, A>
) {
    fun acceptByAggregate(consumer: Consumer1<D, ID, R, D>, aggregate: A) {
        this.accept(consumer, asData.apply(aggregate))
    }

    fun acceptByAggregates(consumer: Consumer1<D, ID, R, List<D>>, aggregates: List<A>) {
        this.accept(consumer, asData(aggregates))
    }

    fun accept(consumer: Consumer0<D, ID, R>) {
        consumer.accept(repository)
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

    fun <P> applyAsAggregate(function: Function1<D, ID, R, P, D>, param: P): A {
        return asDomain.apply(ensureExistence(apply(function, param)))
    }

    fun <P1, P2> applyAsAggregate(
        function: Function2<D, ID, R, P1, P2, D>,
        param1: P1,
        param2: P2
    ): A {
        return asDomain.apply(ensureExistence(apply(function, param1, param2)))
    }

    fun <P1, P2, P3> applyAsAggregate(
        function: Function3<D, ID, R, P1, P2, P3, D>,
        param1: P1,
        param2: P2,
        param3: P3
    ): A {
        return asDomain.apply(ensureExistence(apply(function, param1, param2, param3)))
    }

    fun applyAsAggregates(
        function: Function0<D, ID, R, List<D>>,
    ): List<A> {
        return asDomain(function.apply(repository))
    }

    fun <P> applyAsAggregates(
        function: Function1<D, ID, R, P, List<D>>,
        param: P
    ): List<A> {
        return asDomain(function.apply(repository, param))
    }

    fun <P1, P2> applyAsAggregates(
        function: Function2<D, ID, R, P1, P2, List<D>>,
        param1: P1,
        param2: P2
    ): List<A> {
        return asDomain(function.apply(repository, param1, param2))
    }

    fun <P1, P2, P3> applyAsAggregates(
        function: Function3<D, ID, R, P1, P2, P3, List<D>>,
        param1: P1,
        param2: P2,
        param3: P3
    ): List<A> {
        return asDomain(function.apply(repository, param1, param2, param3))
    }

    fun <E> apply(function: Function0<D, ID, R, E>): AggregatesResult<E, D, A> {
        return AggregatesResult(function.apply(repository), asDomain)
    }

    fun <P, E> apply(function: Function1<D, ID, R, P, E>, param: P): E {
        return function.apply(repository, param)
    }

    fun <P1, P2, E> apply(function: Function2<D, ID, R, P1, P2, E>, param1: P1, param2: P2): E {
        return function.apply(repository, param1, param2)
    }

    fun <P1, P2, P3, E> apply(
        function: Function3<D, ID, R, P1, P2, P3, E>,
        param1: P1,
        param2: P2,
        param3: P3
    ): E {
        return function.apply(repository, param1, param2, param3)
    }

    private fun ensureExistence(data: D): D {
        return Optional.ofNullable(data).orElseThrow { RuntimeException("error.can-not-get-aggregate") }
    }

    private fun asDomain(data: List<D>) = data.stream()
        .peek(this::ensureExistence)
        .map(this.asDomain::apply)
        .collect(Collectors.toList())

    private fun asData(aggregates: List<A>) = aggregates.stream()
        .map(this.asData::apply)
        .collect(Collectors.toList())
}
