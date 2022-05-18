package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class IsGreaterThanBodyCastIntegerMatcher<T extends Comparable<T>> extends SingleValueConstructBodyCastIntegerMatcher<T> {
    IsGreaterThanBodyCastIntegerMatcher(T num) {
        super(num);
    }

    @Override
    protected void realMatch(T value) {
        assertThat(value).isGreaterThan(value());
    }
}
