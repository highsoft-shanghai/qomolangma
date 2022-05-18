package com.example.scaffold.frameworks.test.web;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public final class NotNullBodyMatcher implements GeneralResponseBodyMatcher {
    NotNullBodyMatcher() {
    }

    @Override
    public void match(Object target) {
        assertNotEquals(target, null);
    }

}
