package com.qomolangma.frameworks.security.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RequiredAuthoritiesTest {
    @Test
    fun should_be_able_to_hold_authorities() {
        assertThat(RequiredAuthorities.of("f1", "f2").asSet()).isEqualTo(setOf("f1", "f2"))
    }

    @Test
    fun should_be_able_to_represent_anonymous_requirements() {
        assertThat(RequiredAuthorities.of(Authorities.ANONYMOUS).requireAnonymous()).isTrue
    }

    @Test
    fun should_be_able_to_represent_authenticated_only_requirements() {
        assertThat(RequiredAuthorities.of().requireAuthenticatedOnly()).isTrue
    }

    @Test
    fun should_treat_normal_requirements_as_not_authenticated_only_ones() {
        assertThat(RequiredAuthorities.of("f1").requireAuthenticatedOnly()).isFalse
    }

    @Test
    fun should_be_able_to_represent_explicit_authenticated_only_requirements() {
        assertThat(RequiredAuthorities.of(Authorities.AUTHENTICATED).requireAuthenticatedOnly()).isTrue
    }

    @Test
    fun should_be_treated_as_anonymous_requirements_when_explicit_anonymous_specified() {
        assertThat(RequiredAuthorities.of(Authorities.AUTHENTICATED, Authorities.ANONYMOUS, "f1").requireAnonymous())
            .isTrue
        assertThat(
            RequiredAuthorities.of(Authorities.AUTHENTICATED, Authorities.ANONYMOUS, "f1").requireAuthenticatedOnly()
        ).isFalse
    }

    @Test
    fun should_be_able_to_compare_to_others_by_contents() {
        assertThat(RequiredAuthorities.of("f1", "f2")).isEqualTo(RequiredAuthorities.of("f1", "f2"))
    }

    @Test
    fun should_be_able_to_format_as_simple_string() {
        assertThat(RequiredAuthorities.of("f2", "f1", "f8", "f0").toString())
            .isEqualTo("RequiredAuthorities(f0, f1, f2, f8)")
    }
}
