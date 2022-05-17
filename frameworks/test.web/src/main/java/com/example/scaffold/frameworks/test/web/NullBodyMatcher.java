package com.example.scaffold.frameworks.test.web;

import static org.junit.jupiter.api.Assertions.assertNull;

public final class NullBodyMatcher implements ResponseBodyMatcher {
    private NullBodyMatcher() {
    }

    public static NullBodyMatcher isNull() {
        return new NullBodyMatcher();
    }

    @Override
    public void match(Object target) {
        assertNull(target);
    }
}
