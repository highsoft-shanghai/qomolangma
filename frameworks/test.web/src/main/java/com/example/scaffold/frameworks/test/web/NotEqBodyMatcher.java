package com.example.scaffold.frameworks.test.web;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public final class NotEqBodyMatcher implements GeneralResponseBodyMatcher {
    private final String value;

    NotEqBodyMatcher(String value) {
        this.value = value;
    }

    @Override
    public void match(Object target) {
        assertNotEquals(target, value);
    }
}
