package com.qomolangma.frameworks.security.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContextTest {
    @Test
    fun should_be_able_to_represent_invalid_context() {
        assertThat(Context.INVALID.userContext().valid()).isFalse
        assertThat(Context.INVALID.securityContext().valid()).isFalse
    }
}
