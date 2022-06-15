package com.qomolangma.frameworks.bean.core

import com.qomolangma.frameworks.payload.core.MapFieldType.Companion.asMap
import com.qomolangma.frameworks.payload.core.Payload
import org.springframework.core.MethodParameter
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice

@RestControllerAdvice(basePackages = ["com.qomolangma", "org.springframework.boot.autoconfigure.web.servlet.error"])
class ApiResponseWrapper : ResponseBodyAdvice<Any> {
    override fun supports(returnType: MethodParameter, converterType: Class<out HttpMessageConverter<*>>): Boolean =
        true

    override fun beforeBodyWrite(
        body: Any?,
        returnType: MethodParameter,
        selectedContentType: MediaType,
        selectedConverterType: Class<out HttpMessageConverter<*>>,
        request: ServerHttpRequest,
        response: ServerHttpResponse
    ): Any? {
        response.setStatusCode(HttpStatus.OK)
        return ApiResult.of(request, body(body))
    }

    private fun body(body: Any?) = if (body is Payload) body[asMap()] else body
}
