package com.qomolangma.frameworks.security.core

import com.qomolangma.frameworks.domain.core.DomainException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AuthorizationExceptionTest {
    @Test
    fun should_provide_clear_error_info() {
        val exception = AuthorizationException("error.access-denied")
        assertThat(exception).isInstanceOf(DomainException::class.java)
        assertThat(exception).hasMessage("error.access-denied")
    }
}
