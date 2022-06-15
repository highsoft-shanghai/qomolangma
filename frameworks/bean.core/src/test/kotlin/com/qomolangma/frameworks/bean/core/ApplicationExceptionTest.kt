package com.qomolangma.frameworks.bean.core

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito

class ApplicationExceptionTest {
    @Test
    fun empty_exception_should_be_resolved_as_default_error_message() {
        val exception = ApplicationException()
        val messageResolver = Mockito.mock(MessageResolver::class.java)
        given(messageResolver.resolve(ApplicationException.DEFAULT_MESSAGE_CODE)).willReturn(MESSAGE_FROM_RESOLVER)
        assertEquals(MESSAGE_FROM_RESOLVER, exception.resolveMessage(messageResolver))
    }

    @Test
    fun should_resolve_message_from_message_resolver_with_correct_code_and_args() {
        val exception = ApplicationException("error.code.test", arrayOf(1, 2))
        val messageResolver = Mockito.mock(MessageResolver::class.java)
        given(messageResolver.resolve("error.code.test", 1, 2)).willReturn(MESSAGE_FROM_RESOLVER)
        assertEquals(MESSAGE_FROM_RESOLVER, exception.resolveMessage(messageResolver))
    }

    companion object {
        private const val MESSAGE_FROM_RESOLVER = "default-error-message"
    }
}
