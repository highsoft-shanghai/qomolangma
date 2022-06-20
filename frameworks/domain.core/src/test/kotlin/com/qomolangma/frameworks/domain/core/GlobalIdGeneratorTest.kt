package com.qomolangma.frameworks.domain.core

import com.qomolangma.frameworks.domain.core.GlobalIdGenerator.nextId
import com.qomolangma.frameworks.domain.core.GlobalIdGenerator.nextReadableId
import com.qomolangma.frameworks.domain.core.GlobalIdGeneratorResetter.reset
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GlobalIdGeneratorTest {
    @Test
    fun should_be_able_to_generate_identities_from_underlying_identity_service() {
        reset(UuidBasedIdGenerator())
        assertThat(nextId()).hasSize(32)
        assertThat(nextReadableId()).hasSize(21)
    }
}
