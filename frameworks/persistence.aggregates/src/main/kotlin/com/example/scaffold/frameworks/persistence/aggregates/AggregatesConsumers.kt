package com.example.scaffold.frameworks.persistence.aggregates

import org.springframework.data.repository.Repository

class AggregatesConsumers private constructor() {
    interface Consumer1<D, ID, R : Repository<D, ID>?, P1> {
        fun accept(repo: R, p1: P1)
    }

    interface Consumer2<D, ID, R : Repository<D, ID>?, P1, P2> {
        fun accept(repo: R, p1: P1, p2: P2)
    }

    interface Consumer3<D, ID, R : Repository<D, ID>?, P1, P2, P3> {
        fun accept(repo: R, p1: P1, p2: P2, p3: P3)
    }
}
