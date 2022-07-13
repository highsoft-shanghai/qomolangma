package com.qomolangma.frameworks.security.core

import com.qomolangma.frameworks.domain.core.AuthenticationException
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GrantedAuthoritiesTest {
    @Test
    fun should_be_able_to_hold_authorities() {
        assertThat(GrantedAuthorities.of("f1", "f2").asSet()).isEqualTo(setOf("f1", "f2"))
        assertThat(GrantedAuthorities.of(setOf("f1", "f2")).asSet()).isEqualTo(setOf("f1", "f2"))
    }

    @Test
    fun should_allow_authorized_accesses() {
        org.junit.jupiter.api.Assertions.assertDoesNotThrow {
            GrantedAuthorities.of("f1", "f2").authorize(RequiredAuthorities.of("f2"))
        }
        org.junit.jupiter.api.Assertions.assertDoesNotThrow {
            GrantedAuthorities.of("f1", "f2").authorize(RequiredAuthorities.of("f1"))
        }
    }

    @Test
    fun should_deny_unauthorized_accesses() {
        val throwable =
            Assertions.catchThrowable { GrantedAuthorities.of("f1", "f2").authorize(RequiredAuthorities.of("f3")) }
        assertThat(throwable).isInstanceOf(AuthorizationException::class.java)
        assertThat(throwable).hasMessage("error.access-denied")
    }

    @Test
    fun should_allow_accesses_which_just_require_anonymous() {
        org.junit.jupiter.api.Assertions.assertDoesNotThrow {
            GrantedAuthorities.of("f1", "f2").authorize(RequiredAuthorities.ANONYMOUS)
        }
        org.junit.jupiter.api.Assertions.assertDoesNotThrow {
            GrantedAuthorities.of().authorize(RequiredAuthorities.ANONYMOUS)
        }
    }

    @Test
    fun should_allow_accesses_which_just_require_authenticated() {
        org.junit.jupiter.api.Assertions.assertDoesNotThrow {
            GrantedAuthorities.of("f1", "f2").authorize(RequiredAuthorities.AUTHENTICATED)
        }
    }

    @Test
    fun should_allow_any_accesses_when_it_contains_admin_authority() {
        org.junit.jupiter.api.Assertions.assertDoesNotThrow {
            GrantedAuthorities.of(Authorities.ADMIN).authorize(RequiredAuthorities.of("any-access"))
        }
    }

    @Test
    fun should_allow_any_accesses_when_it_contains_system_authority() {
        org.junit.jupiter.api.Assertions.assertDoesNotThrow {
            GrantedAuthorities.of(Authorities.SYSTEM).authorize(RequiredAuthorities.of("any-access"))
        }
    }

    @Test
    fun should_deny_accesses_which_require_more_than_anonymous_if_it_is_anonymous() {
        val throwable =
            Assertions.catchThrowable { GrantedAuthorities.ANONYMOUS.authorize(RequiredAuthorities.of("f3")) }
        assertThat(throwable).isInstanceOf(AuthenticationException::class.java)
        assertThat(throwable).hasMessage("error.authentication-required")
    }

    @Test
    fun should_be_able_to_format_as_simple_string() {
        assertThat(GrantedAuthorities.of("f1", "f2", "f8", "f0").toString())
            .isEqualTo("GrantedAuthorities(f0, f1, f2, f8)")
    }
}
