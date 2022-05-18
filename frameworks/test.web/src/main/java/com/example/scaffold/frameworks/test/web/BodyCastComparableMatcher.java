package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class BodyCastComparableMatcher<T extends Comparable<T>> extends BodyCastTypeMatcher<T> {
    @Override
    public void match(T value) {
        assertThat(Comparable.class).isAssignableFrom(value.getClass());
        realMatch(value);
    }

    @Override
    protected Class<T> typeClass() {
        return null;
    }
}
