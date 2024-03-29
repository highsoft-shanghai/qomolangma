package com.qomolangma.frameworks.bean.core

import com.qomolangma.frameworks.payload.core.Payload
import lombok.Generated
import org.springframework.core.MethodParameter
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.ModelAndViewContainer
import org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodProcessor

open class PayloadHandlerMethodArgumentResolver constructor(converters: List<HttpMessageConverter<*>>) :
    AbstractMessageConverterMethodProcessor(converters) {
    override fun supportsParameter(parameter: MethodParameter): Boolean {
        return parameter.parameterType.isAssignableFrom(Payload::class.java)
    }

    @Throws(Exception::class)
    @Generated
    override fun resolveArgument(
        parameter: MethodParameter,
        mavContainer: ModelAndViewContainer?,
        webRequest: NativeWebRequest,
        binderFactory: WebDataBinderFactory?
    ): Any? {
        return readWithMessageConverters<Any>(
            webRequest,
            parameter,
            LinkedHashMap::class.java.genericSuperclass
        )?.let {
            Payload(
                it
            )
        }
    }

    override fun supportsReturnType(returnType: MethodParameter): Boolean = false

    override fun handleReturnValue(
        returnValue: Any?,
        returnType: MethodParameter,
        mavContainer: ModelAndViewContainer,
        webRequest: NativeWebRequest
    ) {
    }
}
