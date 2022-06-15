package com.qomolangma.frameworks.bean.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpRequest;

import javax.annotation.Nullable;
import java.util.Map;

public class ApiResult<T> {
    private final String code;
    private final String message;
    private final T data;

    protected ApiResult(HttpRequest request, @Nullable T body) {
        this.code = resolveCode(request);
        this.message = resolveMessage(body);
        this.data = isError() ? null : body;
    }

    public static <U> ApiResult<U> of(HttpRequest request, @Nullable U body) {
        return new ApiResult<>(request, body);
    }

    private String resolveCode(HttpRequest request) {
        return StringUtils.endsWith(request.getURI().getPath(), "/error") ? "1" : "0";
    }

    @SuppressWarnings("unchecked")
    private String resolveMessage(@Nullable Object body) {
        if (!isError()) return "";
        Map<String, Object> errors = (Map<String, Object>) body;
        String error = (String) errors.get("error");
        String message = (String) errors.get("message");
        return StringUtils.equals("No message available", message) ? (StringUtils.equals("Not Found", error) ? "not-found" : "unknown") : message;
    }

    @JsonIgnore
    private boolean isError() {
        return !StringUtils.equals("0", code);
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("msg")
    public String getMessage() {
        return message;
    }

    @JsonProperty("data")
    public @Nullable T getData() {
        return data;
    }
}
