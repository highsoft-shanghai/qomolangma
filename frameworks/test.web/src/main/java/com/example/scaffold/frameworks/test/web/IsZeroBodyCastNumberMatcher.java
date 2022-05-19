package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class IsZeroBodyCastNumberMatcher<T extends Number & Comparable<T>> extends BodyCastNumberMatcher<T> {
    IsZeroBodyCastNumberMatcher() {
    }

    @Override
    protected void realMatch(T value) {
        if (value instanceof Integer) assertThat((Integer) value).isZero();
        if (value instanceof Double) assertThat((Double) value).isZero();
    }
}
