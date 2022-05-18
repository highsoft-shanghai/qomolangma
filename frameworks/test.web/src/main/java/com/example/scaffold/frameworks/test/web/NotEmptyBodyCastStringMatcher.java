package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class NotEmptyBodyCastStringMatcher extends BodyCastStringMatcher {
    NotEmptyBodyCastStringMatcher() {
    }

    @Override
    public void realMatch(String target) {
        assertThat(target).isNotEmpty();
    }
}
