package com.qomolangma.frameworks.bean.core

import org.junit.jupiter.api.Test
import org.springframework.context.MessageSource
import org.springframework.context.MessageSourceResolvable
import java.util.*
import kotlin.test.assertFalse

internal class ExceptionTranslatorTest {
    @Test
    fun should_translate_nothing() {
        val exceptionTranslator = ExceptionTranslator(SpringMessageResolver(TestSource()))
        val error = mutableMapOf<String, Any>()
        assertFalse { exceptionTranslator.handleApplicationException(error, null) }
    }

    class TestSource : MessageSource {
        override fun getMessage(code: String, args: Array<out Any>?, defaultMessage: String?, locale: Locale): String? {
            TODO("Not yet implemented")
        }

        override fun getMessage(code: String, args: Array<out Any>?, locale: Locale): String {
            TODO("Not yet implemented")
        }

        override fun getMessage(resolvable: MessageSourceResolvable, locale: Locale): String {
            TODO("Not yet implemented")
        }

    }
}
