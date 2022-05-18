package com.example.scaffold.frameworks.test.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class EqBodyMatcher implements GeneralResponseBodyMatcher {
    private final Object value;

    private EqBodyMatcher(Object value) {
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
