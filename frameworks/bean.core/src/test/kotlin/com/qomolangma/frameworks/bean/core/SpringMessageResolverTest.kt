package com.qomolangma.frameworks.bean.core

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder

class SpringMessageResolverTest {
    @Test
    fun can_resolve_message_correctly() {
        val messageSource = Mockito.mock(MessageSource::class.java)
        val locale = LocaleContextHolder.getLocale()
        given(messageSource.getMessage(CODE, ARGS, CODE, locale)).willReturn(MESSAGE_FROM_MESSAGE_SOURCE)
        val messageResolver: MessageResolver = SpringMessageResolver(messageSource)
        assertEquals(MESSAGE_FROM_MESSAGE_SOURCE, messageResolver.resolve(CODE, *ARGS))
    }

    companion object {
        private const val MESSAGE_FROM_MESSAGE_SOURCE = "message-from-message-source"
        private const val CODE = "code"
        private val ARGS = arrayOf<Any>(2, 5)
    }
}
