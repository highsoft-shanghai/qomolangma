package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class IsZeroBodyCastIntegerMatcher<T extends Number & Comparable<T>> extends BodyCastNumberMatcher<T> {
    IsZeroBodyCastIntegerMatcher() {
    }

    @Override
    protected void realMatch(T value) {
        if (value instanceof Integer) assertThat((Integer) value).isZero();
        if (value instanceof Long) assertThat((Long) value).isZero();
        if (value instanceof Double) assertThat((Double) value).isZero();
        if (value instanceof Float) assertThat((Float) value).isZero();
        if (value instanceof Short) assertThat((Short) value).isZero();
    }
}
