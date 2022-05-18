package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class IsFalseBodyCastBooleanMatcher extends BodyCastBooleanMatcher {
    IsFalseBodyCastBooleanMatcher() {
    }

    @Override
    @SuppressWarnings("all")
    protected void realMatch(Object value) {
        assertThat((Boolean) value).isFalse();
    }
}
