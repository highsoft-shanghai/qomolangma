package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class IsNotPositiveBodyCastNumberMatcher<T extends Number & Comparable<T>> extends BodyCastNumberMatcher<T> {
    IsNotPositiveBodyCastNumberMatcher() {
    }

    @Override
    protected void realMatch(T value) {
        if (value instanceof Integer) assertThat((Integer) value).isNotPositive();
        if (value instanceof Long) assertThat((Long) value).isNotPositive();
        if (value instanceof Double) assertThat((Double) value).isNotPositive();
    }
}
