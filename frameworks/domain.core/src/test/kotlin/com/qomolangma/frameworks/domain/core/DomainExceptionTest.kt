package com.qomolangma.frameworks.domain.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DomainExceptionTest {
    @Test
    fun should_be_able_to_construct_from_message() {
        val exception = DomainException("a message")
        assertThat(exception).isInstanceOf(RuntimeException::class.java)
        assertThat(exception).hasMessage("a message")
    }

    @Test
    fun should_be_able_to_construct_from_message_and_cause() {
        val cause = IllegalArgumentException()
        val exception = DomainException("a message", cause)
        assertThat(exception).hasMessage("a message")
        assertThat(exception).hasCause(cause)
    }
}
