package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class IsLessThanBodyCastIntegerMatcher<T extends Comparable<T>> extends SingleValueConstructBodyCastIntegerMatcher<T> {
    IsLessThanBodyCastIntegerMatcher(T value) {
        super(value);
    }

    @Override
    protected void realMatch(T value) {
        assertThat(value).isLessThan(value());
    }
}
