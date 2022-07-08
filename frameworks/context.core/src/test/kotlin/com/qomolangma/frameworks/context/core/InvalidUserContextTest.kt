package com.qomolangma.frameworks.context.core

import com.qomolangma.frameworks.domain.core.BadAccessTokenException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class InvalidUserContextTest {
    @Test
    fun should_answer_no_when_test_for_validity() {
        assertThat(UserContext.INVALID.valid()).isFalse
    }

    @Test
    fun should_report_error_when_try_to_get_user_account() {
        assertThatThrownBy { UserContext.INVALID.userAccount() }.isInstanceOf(
            BadAccessTokenException::class.java
        ).hasMessage("error.bad-token")
    }

    @Test
    fun should_report_error_when_try_to_get_user() {
        assertThatThrownBy { UserContext.INVALID.user() }.isInstanceOf(
            BadAccessTokenException::class.java
        ).hasMessage("error.bad-token")
    }

    @Test
    fun should_report_error_when_try_to_get_tenant() {
        assertThatThrownBy { UserContext.INVALID.tenant() }.isInstanceOf(
            BadAccessTokenException::class.java
        ).hasMessage("error.bad-token")
    }
}
