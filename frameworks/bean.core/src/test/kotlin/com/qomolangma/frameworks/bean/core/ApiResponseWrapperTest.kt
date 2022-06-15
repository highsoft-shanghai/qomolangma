package com.qomolangma.frameworks.bean.core

import com.qomolangma.frameworks.bean.core.PayloadHandlerMethodArgumentResolverTest.AnyMethodParameter
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType.ALL
import org.springframework.http.converter.FormHttpMessageConverter
import org.springframework.http.server.ServletServerHttpRequest
import org.springframework.http.server.ServletServerHttpResponse
import org.springframework.mock.web.MockHttpServletRequest
import org.springframework.mock.web.MockHttpServletResponse

internal class ApiResponseWrapperTest {
    @Test
    fun should_get_self_when_given_not_payload() {
        val response = ApiResponseWrapper().beforeBodyWrite(
            NotResponsePayload(),
            AnyMethodParameter(this.javaClass.getConstructor(), -1),
            ALL,
            FormHttpMessageConverter().javaClass,
            ServletServerHttpRequest(MockHttpServletRequest()),
            ServletServerHttpResponse(MockHttpServletResponse())
        );
        assertThat(response).isInstanceOf(ApiResult::class.java)
    }

    private class NotResponsePayload
}
