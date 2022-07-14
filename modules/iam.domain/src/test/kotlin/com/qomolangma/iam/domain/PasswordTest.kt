package com.qomolangma.iam.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class PasswordTest {
    @Test
    fun should_throw_when_password_not_same() {
        assertThrows<IllegalArgumentException> { Password.newInstance("123").confirm("1234") }
    }
}
