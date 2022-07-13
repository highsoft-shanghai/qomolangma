package com.qomolangma.frameworks.test.security

import com.qomolangma.frameworks.security.core.GlobalSecurityContext
import com.qomolangma.frameworks.test.context.WithSecurityContext
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@WithSecurityContext(grantedAuthorities = ["f1", "f2"])
class GlobalSecurityContextExtensionTest {
    @Test
    fun should_be_able_to_reset_security_context() {
        assertThat(GlobalSecurityContext.securityContext().grantedAuthorities().asSet()).containsExactlyInAnyOrder("f1", "f2")
    }
}
