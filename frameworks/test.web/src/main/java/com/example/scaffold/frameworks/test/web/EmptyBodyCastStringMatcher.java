package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class EmptyBodyCastStringMatcher extends BodyCastStringMatcher {
    EmptyBodyCastStringMatcher() {
    }

    @Override
    public void realMatch(String target) {
        assertThat(target).isEmpty();
    }
}
