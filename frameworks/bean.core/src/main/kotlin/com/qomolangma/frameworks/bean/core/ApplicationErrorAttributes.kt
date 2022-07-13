package com.qomolangma.frameworks.bean.core

import org.springframework.boot.web.error.ErrorAttributeOptions
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestAttributes.SCOPE_REQUEST
import org.springframework.web.context.request.WebRequest
import javax.annotation.Resource

@Component
class ApplicationErrorAttributes(
    @Resource private val exceptionTranslator: ExceptionTranslator
) : DefaultErrorAttributes() {
    override fun getErrorAttributes(request: WebRequest, options: ErrorAttributeOptions): Map<String, Any> {
        val error = super.getErrorAttributes(request, options)
        val throwable = getError(request)
        exceptionTranslator.handle(error, throwable)
        request.setAttribute("javax.servlet.error.status_code", error["status"]!!, SCOPE_REQUEST)
        return error
    }
}
