package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class IsGreaterThanOrEqualToBodyCastComparableMatcher<T extends Comparable<T>> extends SingleValueConstructBodyCastComparableMatcher<T> {
    IsGreaterThanOrEqualToBodyCastComparableMatcher(T num) {
        super(num);
    }

    @Override
    protected void realMatch(T value) {
        assertThat(value).isGreaterThanOrEqualTo(value());
    }
}
