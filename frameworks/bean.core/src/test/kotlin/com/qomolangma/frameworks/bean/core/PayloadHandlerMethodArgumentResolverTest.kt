package com.qomolangma.frameworks.bean.core

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter

internal class PayloadHandlerMethodArgumentResolverTest {
    @Test
    fun should_return_false() {
        val payloadHandlerMethodArgumentResolver =
            PayloadHandlerMethodArgumentResolver(listOf(MappingJackson2HttpMessageConverter()))
        assertThat(payloadHandlerMethodArgumentResolver.supportsReturnType(null)).isFalse
        val throwable =
            catchThrowable { payloadHandlerMethodArgumentResolver.handleReturnValue(null, null, null, null) }
        assertThat(throwable).isNull()
    }
}
