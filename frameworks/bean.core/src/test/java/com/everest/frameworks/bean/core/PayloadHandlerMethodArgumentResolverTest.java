package com.everest.frameworks.bean.core;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.List;

class PayloadHandlerMethodArgumentResolverTest {

    @Test
    @SuppressWarnings("all")
    void should_return_false() {
        PayloadHandlerMethodArgumentResolver payloadHandlerMethodArgumentResolver = new PayloadHandlerMethodArgumentResolver(List.of(new MappingJackson2HttpMessageConverter()));
        Assertions.assertThat(payloadHandlerMethodArgumentResolver.supportsReturnType(null)).isFalse();
        Throwable throwable = Assertions.catchThrowable(() -> payloadHandlerMethodArgumentResolver.handleReturnValue(null, null, null, null));
        Assertions.assertThat(throwable).isNull();
    }

}
