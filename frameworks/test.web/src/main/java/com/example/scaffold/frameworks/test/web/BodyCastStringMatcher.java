package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class BodyCastStringMatcher implements BodyCastTypeMatcher {
    @Override
    public void match(Object value) {
        assertThat(value).isInstanceOf(String.class);
        realMatch(value);
    }

    protected abstract void realMatch(Object value);
}
