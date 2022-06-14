package com.qomolangma.frameworks.payload.core;


import lombok.Getter;

import java.util.LinkedHashMap;

import static com.qomolangma.frameworks.payload.core.MapFieldType.asMap;

@Getter
public class Payload {
    private final Object value;

    public Payload(Object value) {
        this.value = value;
    }

    public <I> I get(FieldType<I> type) {
        return type.from(value);
    }

    public <I> I get(String key, FieldType<I> type) {
        return type.from(get(asMap()).get(key));
    }

    public static ValueBuilder append(String key, Object value) {
        ValueBuilder builder = new ValueBuilder();
        builder.append(key, value);
        return builder;
    }

    public static class ValueBuilder {
        private final LinkedHashMap<String, Object> value;

        public ValueBuilder() {
            this.value = new LinkedHashMap<>();
        }

        public ValueBuilder append(String key, Object value) {
            this.value.put(key, value);
            return this;
        }

        public Payload build() {
            return new Payload(this.value);
        }
    }
}
