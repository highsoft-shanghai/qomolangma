package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class IsNullOrEmptyBodyCastStringMatcher extends BodyCastStringMatcher {
    @Override
    public void match(String value) {
        if (value == null) return;
        super.match(value);
    }

    @Override
    protected void realMatch(String value) {
        assertThat(value).isNullOrEmpty();
    }
}
