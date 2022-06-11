package com.example.scaffold.frameworks.valueobjects.payload;

import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
public class ResponsePayload {
    private final Map<String, Object> value;

    public ResponsePayload() {
        this.value = new LinkedHashMap<>();
    }

    public ResponsePayload append(String field, Object value) {
        this.value.put(field, value);
        return this;
    }
}
