package com.example.scaffold.frameworks.test.web;

import static org.junit.jupiter.api.Assertions.assertNull;

public class NullBodyMatcher implements ResponseBodyMatcher {
    public NullBodyMatcher() {
    }

    public static NullBodyMatcher isNull() {
        return new NullBodyMatcher();
    }

    @Override
    public void match(Object target) {
        assertNull(target);
    }
}
