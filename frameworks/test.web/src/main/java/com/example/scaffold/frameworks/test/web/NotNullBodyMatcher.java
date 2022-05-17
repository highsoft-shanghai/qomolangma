package com.example.scaffold.frameworks.test.web;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public final class NotNullBodyMatcher implements ResponseBodyMatcher {
    private NotNullBodyMatcher() {
    }

    public static ResponseBodyMatcher isNotNull() {
        return new NotNullBodyMatcher();
    }

    @Override
    public void match(Object target) {
        assertNotEquals(target, null);
    }

}
