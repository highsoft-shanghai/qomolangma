package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class IsPositiveBodyCastIntegerMatcher<T extends Number & Comparable<T>> extends BodyCastNumberMatcher<T> {
    IsPositiveBodyCastIntegerMatcher() {
    }

    @Override
    protected void realMatch(T value) {
        if (value instanceof Integer) assertThat((Integer) value).isPositive();
        if (value instanceof Long) assertThat((Long) value).isPositive();
        if (value instanceof Double) assertThat((Double) value).isPositive();
        if (value instanceof Float) assertThat((Float) value).isPositive();
        if (value instanceof Short) assertThat((Short) value).isPositive();
    }
}
