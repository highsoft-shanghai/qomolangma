package com.everest.frameworks.domain.core

import lombok.AccessLevel
import lombok.NoArgsConstructor

@NoArgsConstructor(access = AccessLevel.PRIVATE)
object GlobalIdGeneratorResetter {
    @JvmStatic
    fun reset(idGenerator: IdGenerator) {
        GlobalIdGenerator.reset(idGenerator)
    }
}
