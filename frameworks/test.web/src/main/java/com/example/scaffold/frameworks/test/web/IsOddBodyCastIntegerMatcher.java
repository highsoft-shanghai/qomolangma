package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class IsOddBodyCastIntegerMatcher<T extends Number & Comparable<T>> extends BodyCastIntegersMatcher<T> {
    IsOddBodyCastIntegerMatcher() {
    }

    @Override
    protected void realMatch(T value) {
        if (value instanceof Integer) assertThat((Integer) value).isOdd();
        if (value instanceof Long) assertThat((Long) value).isOdd();
        if (value instanceof Short) assertThat((Short) value).isOdd();
    }
}
