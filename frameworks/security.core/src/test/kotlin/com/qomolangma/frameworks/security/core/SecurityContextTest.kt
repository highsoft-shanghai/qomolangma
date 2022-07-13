package com.qomolangma.frameworks.security.core

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class SecurityContextTest {
    @Test
    fun should_be_able_to_represent_anonymous() {
        Assertions.assertThat(SecurityContext.ANONYMOUS.token()).isEqualTo("anonymous")
        Assertions.assertThat(SecurityContext.ANONYMOUS.grantedAuthorities()).isEqualTo(GrantedAuthorities.ANONYMOUS)
    }

    @Test
    fun should_be_able_to_represent_system() {
        Assertions.assertThat(SecurityContext.SYSTEM.token()).isEqualTo("system")
        Assertions.assertThat(SecurityContext.SYSTEM.grantedAuthorities()).isEqualTo(GrantedAuthorities.SYSTEM)
    }

    @Test
    fun should_be_able_to_represent_invalid_context() {
        Assertions.assertThat(SecurityContext.INVALID.valid()).isFalse
    }
}
