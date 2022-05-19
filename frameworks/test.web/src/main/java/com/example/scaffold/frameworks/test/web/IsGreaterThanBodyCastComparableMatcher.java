package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class IsGreaterThanBodyCastComparableMatcher<T extends Comparable<T>> extends SingleValueConstructBodyCastComparableMatcher<T> {
    IsGreaterThanBodyCastComparableMatcher(T num) {
        super(num);
    }

    @Override
    protected void realMatch(T value) {
        assertThat(value).isGreaterThan(value());
    }
}
