package com.qomolangma.frameworks.domain.core

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FixedIdGeneratorTest {
    @Test
    fun should_generate_fixed_identity() {
        val id: Id = FixedId(FIXED)
        assertThat(id.next()).isEqualTo(FIXED)
        assertThat(id.nextReadable()).isEqualTo(FIXED)
    }

    companion object {
        const val FIXED = "fixed"
    }
}
