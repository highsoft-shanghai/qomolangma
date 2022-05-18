package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class SizeBodyMatcher implements ResponseBodyMultiValuesMatcher {
    private final int size;

    SizeBodyMatcher(int size) {
        this.size = size;
    }

    @Override
    public void match(Object[] values) {
        assertThat(values).hasSize(size);
    }
}
