package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class IsEvenBodyCastIntegerMatcher<T extends Number & Comparable<T>> extends BodyCastIntegersMatcher<T> {
    IsEvenBodyCastIntegerMatcher() {
    }

    @Override
    protected void realMatch(T value) {
        if (value instanceof Integer) assertThat((Integer) value).isEven();
        if (value instanceof Long) assertThat((Long) value).isEven();
        if (value instanceof Short) assertThat((Short) value).isEven();
    }
}
