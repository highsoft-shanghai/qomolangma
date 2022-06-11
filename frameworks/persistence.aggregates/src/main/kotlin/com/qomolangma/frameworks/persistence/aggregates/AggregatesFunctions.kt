package com.qomolangma.frameworks.persistence.aggregates

import org.springframework.data.repository.Repository

class AggregatesFunctions private constructor() {
    interface Function0<D, ID, R : Repository<D, ID>, E> {
        fun apply(repo: R): E
    }

    interface Function1<D, ID, R : Repository<D, ID>, P1, E> {
        fun apply(repo: R, p1: P1): E
    }

    interface Function2<D, ID, R : Repository<D, ID>, P1, P2, E> {
        fun apply(repo: R, p1: P1, p2: P2): E
    }

    interface Function3<D, ID, R : Repository<D, ID>, P1, P2, P3, E> {
        fun apply(repo: R, p1: P1, p2: P2, p3: P3): E
    }
}
