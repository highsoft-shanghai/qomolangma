package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class HasSizeBodyCastStringMatcher extends BodyCastStringMatcher {
    private final int size;

    HasSizeBodyCastStringMatcher(int size) {
        this.size = size;
    }

    @Override
    public void realMatch(Object target) {
        assertThat((String) target).hasSize(size);
    }
}
