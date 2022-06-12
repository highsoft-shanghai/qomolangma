package com.qomolangma.frameworks.domain.core

import lombok.AccessLevel
import lombok.NoArgsConstructor

@NoArgsConstructor(access = AccessLevel.PRIVATE)
object GlobalIdGeneratorResetter {
    @JvmStatic
    fun reset(idGenerator: Id) {
        GlobalIdGenerator.reset(idGenerator)
    }
}
