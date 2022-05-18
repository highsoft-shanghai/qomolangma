package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class IsNegativeBodyCastNumberMatcher<T extends Number & Comparable<T>> extends BodyCastNumberMatcher<T> {
    IsNegativeBodyCastNumberMatcher() {
    }

    @Override
    protected void realMatch(T value) {
        if (value instanceof Integer) assertThat((Integer) value).isNegative();
        if (value instanceof Long) assertThat((Long) value).isNegative();
        if (value instanceof Double) assertThat((Double) value).isNegative();
        if (value instanceof Float) assertThat((Float) value).isNegative();
        if (value instanceof Short) assertThat((Short) value).isNegative();
    }
}
