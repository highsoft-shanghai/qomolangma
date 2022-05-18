package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class IsPositiveBodyCastIntegerMatcher extends BodyCastIntegerMatcher {
    IsPositiveBodyCastIntegerMatcher() {
    }

    @Override
    protected void realMatch(Object value) {
        assertThat((Integer) value).isPositive();
    }
}
