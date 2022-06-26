package com.qomolangma.frameworks.bean.core

import com.google.common.collect.ImmutableMap
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.http.HttpRequest
import java.net.URI

internal class ApiResultTest {
    @Test
    fun should_be_able_to_construct_successful_result() {
        val request = Mockito.mock(HttpRequest::class.java)
        BDDMockito.given(request.uri).willReturn(URI.create("/not-error"))
        val body = "test"
        val result: ApiResult<*> = ApiResult.of(request, body)
        Assertions.assertThat(result.code).isEqualTo("0")
        Assertions.assertThat(result.message).isEmpty()
        Assertions.assertThat(result.getData()).isEqualTo(body)
    }

    @Test
    fun should_be_able_to_construct_generic_error_result() {
        val request = Mockito.mock(HttpRequest::class.java)
        BDDMockito.given(request.uri).willReturn(URI.create("/error"))
        val body: Map<String, Any> =
            ImmutableMap.of<String, Any>("status", 404, "error", "Not Found", "message", "No message available")
        val result: ApiResult<*> = ApiResult.of(request, body)
        Assertions.assertThat(result.code).isEqualTo("1")
        Assertions.assertThat(result.message).isEqualTo("not-found")
        Assertions.assertThat(result.getData()).isNull()
    }

    @Test
    fun should_be_able_to_construct_customized_error_result() {
        val request = Mockito.mock(HttpRequest::class.java)
        BDDMockito.given(request.uri).willReturn(URI.create("/error"))
        val body: Map<String, Any> =
            ImmutableMap.of<String, Any>("status", 404, "error", "Not Found", "message", "error.user-not-found")
        val result: ApiResult<*> = ApiResult.of(request, body)
        Assertions.assertThat(result.code).isEqualTo("1")
        Assertions.assertThat(result.message).isEqualTo("error.user-not-found")
        Assertions.assertThat(result.getData()).isNull()
    }

    @Test
    fun should_translate_other_http_errors_into_unknown_errors() {
        val request = Mockito.mock(HttpRequest::class.java)
        BDDMockito.given(request.uri).willReturn(URI.create("/error"))
        val body: Map<String, Any> =
            ImmutableMap.of<String, Any>("status", 404, "error", "Not", "message", "No message available")
        val result: ApiResult<*> = ApiResult.of(request, body)
        Assertions.assertThat(result.code).isEqualTo("1")
        Assertions.assertThat(result.message).isEqualTo("unknown")
        Assertions.assertThat(result.getData()).isNull()
    }
}
