package com.qomolangma.frameworks.bean.core

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import org.apache.commons.lang3.StringUtils
import org.springframework.http.HttpRequest

open class ApiResult<T> protected constructor(request: HttpRequest, body: T?) {
    @get:JsonProperty("code")
    val code: String

    @get:JsonProperty("msg")
    val message: String?
    private val data: T?

    init {
        this.code = resolveCode(request)
        message = resolveMessage(body)
        data = if (isError) null else body
    }

    private fun resolveCode(request: HttpRequest): String {
        return if (StringUtils.endsWith(request.uri.path, "/error")) "1" else "0"
    }

    private fun resolveMessage(body: Any?): String? {
        if (!isError) return ""
        val errors = body as Map<*, *>?
        val error = errors!!["error"] as String?
        val message = message(errors)
        return if (StringUtils.equals("No message available", message)) if (StringUtils.equals(
                "Not Found",
                error
            )
        ) "not-found" else "unknown" else message
    }

    private fun message(errors: Map<*, *>): String {
        if (errors.containsKey("message")) return errors["message"] as String
        return errors["error"] as String
    }

    @get:JsonIgnore
    private val isError: Boolean
        get() = !StringUtils.equals("0", code)

    @JsonProperty("data")
    fun getData(): T? {
        return data
    }

    companion object {
        fun <U> of(request: HttpRequest, body: U?): ApiResult<U?> {
            return ApiResult(request, body)
        }
    }
}
