package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class IsOneBodyCastIntegersMatcher<T extends Number & Comparable<T>> extends BodyCastNumberMatcher<T> {
    IsOneBodyCastIntegersMatcher() {
    }

    @Override
    protected void realMatch(T value) {
        if (value instanceof Integer) assertThat((Integer) value).isOne();
        if (value instanceof Double) assertThat((Double) value).isOne();
    }
}
