package com.example.scaffold.frameworks.test.web;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class NotNullBodyMatcher implements ResponseBodyMatcher {
    public static ResponseBodyMatcher isNotNull() {
        return new NotNullBodyMatcher();
    }

    @Override
    public void match(Object target) {
        assertNotEquals(target, null);
    }

}
