package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class IsNotNegativeBodyCastNumberMatcher<T extends Number & Comparable<T>> extends BodyCastNumberMatcher<T> {
    IsNotNegativeBodyCastNumberMatcher() {
    }

    @Override
    protected void realMatch(T value) {
        if (value instanceof Integer) assertThat((Integer) value).isNotNegative();
        if (value instanceof Long) assertThat((Long) value).isNotNegative();
        if (value instanceof Double) assertThat((Double) value).isNotNegative();
        if (value instanceof Float) assertThat((Float) value).isNotNegative();
        if (value instanceof Short) assertThat((Short) value).isNotNegative();
    }
}
