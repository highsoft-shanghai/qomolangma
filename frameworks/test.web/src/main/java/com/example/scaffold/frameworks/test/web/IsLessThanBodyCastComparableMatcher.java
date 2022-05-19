package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class IsLessThanBodyCastComparableMatcher<T extends Comparable<T>> extends SingleValueConstructBodyCastComparableMatcher<T> {
    IsLessThanBodyCastComparableMatcher(T value) {
        super(value);
    }

    @Override
    protected void realMatch(T value) {
        assertThat(value).isLessThan(value());
    }
}
