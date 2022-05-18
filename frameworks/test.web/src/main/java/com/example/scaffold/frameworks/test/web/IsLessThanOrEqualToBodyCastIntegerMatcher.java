package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class IsLessThanOrEqualToBodyCastIntegerMatcher<T extends Comparable<T>> extends SingleValueConstructBodyCastIntegerMatcher<T> {
    IsLessThanOrEqualToBodyCastIntegerMatcher(T value) {
        super(value);
    }

    @Override
    protected void realMatch(T value) {
        assertThat(value).isLessThanOrEqualTo(value());
    }
}
