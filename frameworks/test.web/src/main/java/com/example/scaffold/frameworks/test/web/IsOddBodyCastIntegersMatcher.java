package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class IsOddBodyCastIntegersMatcher<T extends Number & Comparable<T>> extends BodyCastIntegersMatcher<T> {
    IsOddBodyCastIntegersMatcher() {
    }

    @Override
    protected void realMatch(T value) {
        if (value instanceof Integer) assertThat((Integer) value).isOdd();
        if (value instanceof Long) assertThat((Long) value).isOdd();
        if (value instanceof Short) assertThat((Short) value).isOdd();
    }
}
