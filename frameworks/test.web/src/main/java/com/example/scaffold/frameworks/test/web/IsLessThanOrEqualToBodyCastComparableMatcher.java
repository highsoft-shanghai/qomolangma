package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class IsLessThanOrEqualToBodyCastComparableMatcher<T extends Comparable<T>> extends SingleValueConstructBodyCastComparableMatcher<T> {
    IsLessThanOrEqualToBodyCastComparableMatcher(T value) {
        super(value);
    }

    @Override
    protected void realMatch(T value) {
        assertThat(value).isLessThanOrEqualTo(value());
    }
}
