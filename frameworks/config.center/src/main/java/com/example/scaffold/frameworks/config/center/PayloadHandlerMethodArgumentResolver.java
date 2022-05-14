package com.example.scaffold.frameworks.config.center;

import com.example.scaffold.frameworks.valueobjects.payload.Payload;
import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodProcessor;

import java.util.LinkedHashMap;
import java.util.List;

public class PayloadHandlerMethodArgumentResolver extends AbstractMessageConverterMethodProcessor {

    protected PayloadHandlerMethodArgumentResolver(List<HttpMessageConverter<?>> converters) {
        super(converters);
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(Payload.class);
    }

    @Override
    public Object resolveArgument(@NonNull MethodParameter parameter, ModelAndViewContainer mavContainer, @NonNull NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        Object arg = readWithMessageConverters(webRequest, parameter, LinkedHashMap.class.getGenericSuperclass());
        return new Payload(arg);
    }

    @Override
    public boolean supportsReturnType(@NonNull MethodParameter returnType) {
        return false;
    }

    @Override
    public void handleReturnValue(Object returnValue, @NonNull MethodParameter returnType, @NonNull ModelAndViewContainer mavContainer,
                                  @NonNull NativeWebRequest webRequest) {
    }
}
