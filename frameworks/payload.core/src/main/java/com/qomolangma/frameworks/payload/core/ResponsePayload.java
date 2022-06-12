package com.qomolangma.frameworks.payload.core;

import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
public final class ResponsePayload {
    private final Map<String, Object> value;

    private ResponsePayload() {
        this.value = new LinkedHashMap<>();
    }

    public static ResponsePayload response() {
        return new ResponsePayload();
    }

    public ResponsePayload append(String field, Object value) {
        this.value.put(field, value);
        return this;
    }
}
