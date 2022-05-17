package com.example.scaffold.frameworks.test.web;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public final class NotEqBodyMatcher implements ResponseBodyMatcher {
    private final String value;

    private NotEqBodyMatcher(String value) {
        this.value = value;
    }

    public static ResponseBodyMatcher notEq(String value) {
        return new NotEqBodyMatcher(value);
    }

    @Override
    public void match(Object target) {
        assertNotEquals(target, value);
    }
}
