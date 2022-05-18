package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class IsGreaterThanBodyCastIntegerMatcher extends SingleValueConstructBodyCastIntegerMatcher {
    IsGreaterThanBodyCastIntegerMatcher(Integer num) {
        super(num);
    }

    @Override
    protected void realMatch(Object value) {
        assertThat((Integer) value).isGreaterThan(value());
    }
}
