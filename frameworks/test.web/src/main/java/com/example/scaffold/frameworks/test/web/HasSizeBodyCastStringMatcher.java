package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class HasSizeBodyCastStringMatcher extends BodyCastStringMatcher {
    private final int size;

    private HasSizeBodyCastStringMatcher(int size) {
        this.size = size;
    }

    public static ResponseBodyMatcher hasSize(int size) {
        return new HasSizeBodyCastStringMatcher(size);
    }

    @Override
    public void realMatch(Object target) {
        assertThat((String) target).hasSize(size);
    }
}
