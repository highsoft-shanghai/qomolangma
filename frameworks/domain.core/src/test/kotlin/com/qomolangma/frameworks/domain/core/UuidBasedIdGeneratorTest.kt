package com.qomolangma.frameworks.domain.core

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class UuidBasedIdGeneratorTest {
    private var id: Id? = null

    @BeforeEach
    fun setUp() {
        id = UuidBasedId()
    }

    @Test
    fun should_generate_identity_correctly() {
        Assertions.assertThat(32).isEqualTo(id!!.next().length)
    }

    @Test
    fun should_generate_non_duplicated_identities() {
        val id = id!!.next()
        Assertions.assertThat(id).isNotEqualTo(this.id!!.next())
    }

    @Test
    fun should_generate_readable_identity_correctly() {
        Assertions.assertThat(id!!.nextReadable().length).isEqualTo(21)
        Assertions.assertThat(
            id!!.nextReadable().chars().allMatch { codePoint: Int -> Character.isDigit(codePoint) }).isTrue
    }

    @Test
    fun should_generate_non_duplicated_readable_identities() {
        val id = id!!.nextReadable()
        Assertions.assertThat(this.id!!.nextReadable()).isNotEqualTo(id)
    }
}
