package com.example.scaffold.frameworks.test.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EqBodyMatcher implements ResponseBodyMatcher {
    private final Object value;

    public EqBodyMatcher(Object value) {
        this.value = value;
    }

    public static EqBodyMatcher eq(Object value) {
        return new EqBodyMatcher(value);
    }

    @Override
    public void match(Object target) {
        assertEquals(target, value);
    }
}
