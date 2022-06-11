package com.example.scaffold.frameworks.config.center;

import com.example.scaffold.frameworks.valueobjects.payload.ResponsePayload;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.annotation.Nullable;

import static com.example.scaffold.frameworks.valueobjects.payload.ResponsePayload.response;

@RestControllerAdvice(basePackages = {"com.example", "org.springframework.boot.autoconfigure.web.servlet.error"})
public class ApiResponseWrapper implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(@NotNull MethodParameter returnType, @NotNull Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(
            @Nullable Object body, @NotNull MethodParameter returnType, @NotNull MediaType selectedContentType,
            @NotNull Class<? extends HttpMessageConverter<?>> selectedConverterType, @NotNull ServerHttpRequest request, @NotNull ServerHttpResponse response
    ) {
        if (body == null) return response();
        if (body instanceof ResponsePayload payload) return payload.getValue();
        return body;
    }
}
