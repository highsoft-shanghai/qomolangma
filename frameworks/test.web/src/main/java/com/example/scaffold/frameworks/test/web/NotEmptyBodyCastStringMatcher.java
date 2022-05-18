package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class NotEmptyBodyCastStringMatcher implements BodyCastStringMatcher {
    private NotEmptyBodyCastStringMatcher() {
    }

    public static ResponseBodyMatcher isNotEmpty() {
        return new NotEmptyBodyCastStringMatcher();
    }

    @Override
    public void match(Object target) {
        assertThat(target).isInstanceOf(String.class);
        assertThat((String) target).isNotEmpty();
    }
}
