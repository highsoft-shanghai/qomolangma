package com.qomolangma.frameworks.security.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@WithSecurityContext(grantedAuthorities = ["f1", "f2"])
class GlobalGlobalSecurityContextTest {
    @Test
    fun should_be_able_to_reset_security_context() {
        assertThat(GlobalSecurityContext.securityContext().grantedAuthorities().asSet())
            .containsExactlyInAnyOrder("f1", "f2")
    }

    @Test
    fun should_be_able_to_reset_to_defaults() {
        GlobalSecurityContextResetter.clear()
        assertThat(GlobalSecurityContext.securityContext()).isEqualTo(SecurityContext.ANONYMOUS)
    }
}
