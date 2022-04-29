package com.example.frameworks.domain.core;

import static com.example.frameworks.domain.core.MapFieldType.asMap;

public class Payload {
    private final Object value;

    public Payload(Object value) {
        this.value = value;
    }

    public <T> T get(FieldType<T> type) {
        return type.from(value);
    }

    public <T> T get(String key, FieldType<T> type) {
        return type.from(get(asMap()).get(key));
    }
}
