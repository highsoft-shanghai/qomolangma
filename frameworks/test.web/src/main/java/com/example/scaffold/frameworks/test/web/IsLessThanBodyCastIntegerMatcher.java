package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class IsLessThanBodyCastIntegerMatcher extends ComparableBodyCastIntegerMatcher {
    IsLessThanBodyCastIntegerMatcher(Integer value) {
        super(value);
    }

    @Override
    protected void realMatch(Object value) {
        assertThat((Integer) value).isLessThan(value());
    }
}
