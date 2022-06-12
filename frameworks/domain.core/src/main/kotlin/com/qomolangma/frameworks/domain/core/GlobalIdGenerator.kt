package com.qomolangma.frameworks.domain.core

import lombok.AccessLevel
import lombok.NoArgsConstructor

@NoArgsConstructor(access = AccessLevel.PRIVATE)
object GlobalIdGenerator {
    private var idGenerator: Id = UuidBasedId()

    @JvmStatic
    fun nextId(): String {
        return idGenerator.next()
    }

    @JvmStatic
    fun nextReadableId(): String {
        return idGenerator.nextReadable()
    }

    @JvmStatic
    fun reset(idGenerator: Id) {
        GlobalIdGenerator.idGenerator = idGenerator
    }
}
