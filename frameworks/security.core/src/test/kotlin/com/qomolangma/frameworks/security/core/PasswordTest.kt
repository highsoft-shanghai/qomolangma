package com.qomolangma.frameworks.security.core

import com.qomolangma.frameworks.security.core.Password
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class PasswordTest {
    @Test
    fun should_throw_when_password_not_same() {
        assertThrows<IllegalArgumentException> { Password.newInstance("123").confirm("1234") }
    }
}
