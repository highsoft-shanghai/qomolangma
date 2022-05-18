package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class NotEmptyBodyCastStringMatcher extends BodyCastStringMatcher {
    private NotEmptyBodyCastStringMatcher() {
    }

    public static ResponseBodyMatcher isNotEmpty() {
        return new NotEmptyBodyCastStringMatcher();
    }

    @Override
    public void realMatch(Object target) {
        assertThat((String) target).isNotEmpty();
    }
}
