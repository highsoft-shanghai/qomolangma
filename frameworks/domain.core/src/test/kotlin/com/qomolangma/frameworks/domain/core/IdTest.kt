package com.qomolangma.frameworks.domain.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IdTest {
    @Test
    fun should_id_equals_with_id() {
        assertEquals(Id("1"), Id("1"))
    }

    @Test
    fun should_create_uuid_id() {
        assertThat(Id().id()).hasSize(32)
    }

    @Test
    fun should_create_id_by_customize() {
        assertEquals("123", Id("123").id())
    }
}
