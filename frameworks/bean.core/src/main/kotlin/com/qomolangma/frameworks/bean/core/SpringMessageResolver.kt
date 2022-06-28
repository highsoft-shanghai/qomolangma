package com.qomolangma.frameworks.bean.core

import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.stereotype.Component

@Component
class SpringMessageResolver(private val messageSource: MessageSource) : MessageResolver {
    override fun resolve(code: String, vararg args: Any?): String {
        return messageSource.getMessage(code, args, code, LocaleContextHolder.getLocale())!!
    }
}
