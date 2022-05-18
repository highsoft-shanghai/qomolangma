package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class BodyCastComparableMatcher extends BodyCastTypeMatcher {
    @Override
    public void match(Object value) {
        assertThat(typeClass()).isAssignableFrom(value.getClass());
        realMatch(value);
    }

    @Override
    protected Class<?> typeClass() {
        return Comparable.class;
    }
}
