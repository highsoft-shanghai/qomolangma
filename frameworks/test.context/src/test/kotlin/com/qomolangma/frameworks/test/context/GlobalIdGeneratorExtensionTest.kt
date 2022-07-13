package com.qomolangma.frameworks.test.context

import com.qomolangma.frameworks.domain.core.GlobalIdGenerator.nextId
import com.qomolangma.frameworks.domain.core.GlobalIdGenerator.nextReadableId
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@WithGlobalId(value = "a-fixed-id")
class GlobalIdGeneratorExtensionTest {
    @Test
    fun should_be_able_to_reset_security_context() {
        assertThat(nextId()).isEqualTo("a-fixed-id")
        assertThat(nextReadableId()).isEqualTo("a-fixed-id")
    }
}
