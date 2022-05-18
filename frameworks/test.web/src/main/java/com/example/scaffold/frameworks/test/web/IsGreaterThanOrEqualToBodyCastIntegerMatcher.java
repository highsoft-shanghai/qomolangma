package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class IsGreaterThanOrEqualToBodyCastIntegerMatcher<T extends Comparable<T>> extends SingleValueConstructBodyCastIntegerMatcher<T> {
    IsGreaterThanOrEqualToBodyCastIntegerMatcher(T num) {
        super(num);
    }

    @Override
    protected void realMatch(T value) {
        assertThat(value).isGreaterThanOrEqualTo(value());
    }
}
