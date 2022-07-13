package com.qomolangma.frameworks.security.core

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

@WithSecurityContext(grantedAuthorities = ["f1"])
internal class AuthorizerTest {
    @Test
    fun should_be_able_to_authorize_requests_against_security_context() {
        val authorizer = Authorizer()
        assertDoesNotThrow { authorizer.authorize("f1", "f2") }
    }
}
