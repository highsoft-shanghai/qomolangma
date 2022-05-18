package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class BodyCastTypeMatcher<T> implements ResponseBodyMatcher<T> {
    @Override
    public void match(T value) {
        assertThat(value).isInstanceOf(typeClass());
        realMatch(value);
    }

    protected abstract Class<T> typeClass();

    protected abstract void realMatch(T value);
}
