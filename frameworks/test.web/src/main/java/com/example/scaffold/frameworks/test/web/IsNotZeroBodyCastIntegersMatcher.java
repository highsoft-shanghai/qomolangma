package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class IsNotZeroBodyCastIntegersMatcher<T extends Number & Comparable<T>> extends BodyCastNumberMatcher<T> {
    IsNotZeroBodyCastIntegersMatcher() {
    }

    @Override
    protected void realMatch(T value) {
        if (value instanceof Integer) assertThat((Integer) value).isNotZero();
        if (value instanceof Long) assertThat((Long) value).isNotZero();
        if (value instanceof Double) assertThat((Double) value).isNotZero();
    }
}
