package com.qomolangma.frameworks.bean.core

import org.apache.catalina.connector.Request
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test
import org.springframework.core.MethodParameter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.context.request.ServletWebRequest
import org.springframework.web.method.support.ModelAndViewContainer
import java.lang.reflect.Constructor

internal class PayloadHandlerMethodArgumentResolverTest {
    @Test
    fun should_return_false() {
        val payloadHandlerMethodArgumentResolver =
            PayloadHandlerMethodArgumentResolver(listOf(MappingJackson2HttpMessageConverter()))
        assertThat(
            payloadHandlerMethodArgumentResolver.supportsReturnType(
                AnyMethodParameter(
                    this.javaClass.getConstructor(),
                    -1
                )
            )
        ).isFalse
        val throwable =
            catchThrowable {
                payloadHandlerMethodArgumentResolver.handleReturnValue(
                    null, AnyMethodParameter(
                        this.javaClass.getConstructor(),
                        -1
                    ), ModelAndViewContainer(), ServletWebRequest(Request(null), null)
                )
            }
        assertThat(throwable).isNull()
    }

    class AnyMethodParameter(constructor: Constructor<*>, parameterIndex: Int) :
        MethodParameter(constructor, parameterIndex) {
    }
}
