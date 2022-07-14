package com.qomolangma.frameworks.security.core

import com.qomolangma.frameworks.domain.core.AuthenticationException
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class SimpleSecurityContextTest {
    @Test
    fun should_answer_yes_when_test_for_validity() {
        Assertions.assertThat(SimpleSecurityContext("simple", GrantedAuthorities.ANONYMOUS).valid()).isTrue
    }

    @Test
    fun should_be_able_to_hold_granted_authorities() {
        val context = SimpleSecurityContext("simple", GrantedAuthorities.ANONYMOUS)
        Assertions.assertThat(context.id()).isEqualTo("simple")
        Assertions.assertThat(context.grantedAuthorities()).isEqualTo(GrantedAuthorities.ANONYMOUS)
    }

    @Test
    fun should_delegate_authorization_to_underlying_granted_authorities() {
        val context = SimpleSecurityContext("simple", GrantedAuthorities.ANONYMOUS)
        Assertions.assertThatThrownBy { context.authorize(RequiredAuthorities.AUTHENTICATED) }.isInstanceOf(
            AuthenticationException::class.java
        )
    }
}
