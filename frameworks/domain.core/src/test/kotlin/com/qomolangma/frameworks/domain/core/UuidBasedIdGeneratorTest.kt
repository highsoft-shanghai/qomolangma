package com.qomolangma.frameworks.domain.core

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class UuidBasedIdGeneratorTest {
    private var idGenerator: IdGenerator? = null

    @BeforeEach
    fun setUp() {
        idGenerator = UuidBasedIdGenerator()
    }

    @Test
    fun should_generate_identity_correctly() {
        Assertions.assertThat(32).isEqualTo(idGenerator!!.next().length)
    }

    @Test
    fun should_generate_non_duplicated_identities() {
        val id = idGenerator!!.next()
        Assertions.assertThat(id).isNotEqualTo(this.idGenerator!!.next())
    }

    @Test
    fun should_generate_readable_identity_correctly() {
        Assertions.assertThat(idGenerator!!.nextReadable().length).isEqualTo(21)
        Assertions.assertThat(
            idGenerator!!.nextReadable().chars().allMatch(Character::isDigit)
        ).isTrue
    }

    @Test
    fun should_generate_non_duplicated_readable_identities() {
        val id = idGenerator!!.nextReadable()
        Assertions.assertThat(this.idGenerator!!.nextReadable()).isNotEqualTo(id)
    }
}
