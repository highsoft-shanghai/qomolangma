package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class IsNotPositiveBodyCastIntegerMatcher extends BodyCastIntegerMatcher {
    IsNotPositiveBodyCastIntegerMatcher() {
    }

    @Override
    protected void realMatch(Object value) {
        assertThat((Integer) value).isNotPositive();
    }
}
