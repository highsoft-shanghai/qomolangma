package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class BodyCastTypeMatcher implements ResponseBodyMatcher {
    @Override
    public void match(Object value) {
        assertThat(value).isInstanceOf(typeClass());
        realMatch(value);
    }

    protected abstract Class<?> typeClass();

    protected abstract void realMatch(Object value);
}
