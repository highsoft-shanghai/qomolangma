package com.qomolangma.frameworks.context.core

import com.qomolangma.frameworks.context.core.UserContext.Companion.INVALID
import com.qomolangma.frameworks.domain.core.BadAccessTokenException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class InvalidUserContextTest {
    @Test
    fun should_answer_no_when_test_for_validity() {
        assertThat(INVALID.valid()).isFalse
    }

    @Test
    fun should_report_error_when_try_to_get_user_account() {
        assertThatThrownBy { INVALID.userAccount() }.isInstanceOf(
            BadAccessTokenException::class.java
        ).hasMessage("error.bad-token")
    }

    @Test
    fun should_report_error_when_try_to_get_user() {
        assertThatThrownBy { INVALID.user() }.isInstanceOf(
            BadAccessTokenException::class.java
        ).hasMessage("error.bad-token")
    }

    @Test
    fun should_report_error_when_try_to_get_tenant() {
        assertThatThrownBy { INVALID.tenant() }.isInstanceOf(
            BadAccessTokenException::class.java
        ).hasMessage("error.bad-token")
    }

    @Test
    fun should_report_error_when_try_to_get_password() {
        assertThatThrownBy { INVALID.password() }.isInstanceOf(
            BadAccessTokenException::class.java
        ).hasMessage("error.bad-token")
    }
}
