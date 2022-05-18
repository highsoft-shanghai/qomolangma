package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class IsOneBodyCastIntegerMatcher extends BodyCastIntegerMatcher {
    IsOneBodyCastIntegerMatcher() {
    }

    @Override
    protected void realMatch(Object value) {
        assertThat((Integer) value).isOne();
    }
}
