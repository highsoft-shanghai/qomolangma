package com.qomolangma.frameworks.domain.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FixedIdGeneratorTest {
    @Test
    fun should_generate_fixed_identity() {
        val idGenerator: IdGenerator = FixedIdGenerator(FIXED)
        assertThat(idGenerator.next()).isEqualTo(FIXED)
        assertThat(idGenerator.nextReadable()).isEqualTo(FIXED)
    }

    companion object {
        const val FIXED = "fixed"
    }
}
