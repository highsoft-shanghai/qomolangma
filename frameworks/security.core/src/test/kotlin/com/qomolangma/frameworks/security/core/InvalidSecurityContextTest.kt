package com.qomolangma.frameworks.security.core

import com.qomolangma.frameworks.domain.core.AuthenticationException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class InvalidSecurityContextTest {
    @Test
    fun should_answer_no_when_test_for_validity() {
        assertThat(InvalidSecurityContext().valid()).isFalse
    }

    @Test
    fun should_report_error_when_try_to_get_token() {
        assertThatThrownBy { InvalidSecurityContext().token() }.isInstanceOf(
            AuthenticationException::class.java
        ).hasMessage("error.bad-token")
    }

    @Test
    fun should_report_error_when_try_to_get_authorities() {
        assertThatThrownBy { InvalidSecurityContext().grantedAuthorities() }.isInstanceOf(
            AuthenticationException::class.java
        ).hasMessage("error.bad-token")
    }

    @Test
    fun should_report_error_when_try_to_authorize_requests() {
        assertThatThrownBy { InvalidSecurityContext().authorize(RequiredAuthorities.ANONYMOUS) }
            .isInstanceOf(
                AuthenticationException::class.java
            ).hasMessage("error.bad-token")
    }
}
