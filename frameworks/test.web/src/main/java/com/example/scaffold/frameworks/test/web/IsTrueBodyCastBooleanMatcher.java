package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class IsTrueBodyCastBooleanMatcher extends BodyCastBooleanMatcher {
    IsTrueBodyCastBooleanMatcher() {
    }

    @Override
    protected void realMatch(Boolean value) {
        assertThat(value).isTrue();
    }
}
