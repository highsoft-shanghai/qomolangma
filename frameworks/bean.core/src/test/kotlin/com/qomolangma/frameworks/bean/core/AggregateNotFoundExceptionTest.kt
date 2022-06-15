package com.qomolangma.frameworks.bean.core

import com.qomolangma.frameworks.domain.core.AggregateNotFoundException
import com.qomolangma.frameworks.domain.core.DomainException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AggregateNotFoundExceptionTest {
    @Test
    fun should_be_able_to_construct_from_error_id() {
        val exception = AggregateNotFoundException("error.message-id")
        assertThat(exception).isInstanceOf(DomainException::class.java)
        assertThat(exception).hasMessage("error.message-id")
    }
}
