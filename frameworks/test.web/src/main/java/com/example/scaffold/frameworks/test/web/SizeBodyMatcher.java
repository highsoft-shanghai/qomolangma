package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public class SizeBodyMatcher implements ResponseBodyMultiValuesMatcher {
    private final int size;

    public SizeBodyMatcher(int size) {
        this.size = size;
    }

    public static ResponseBodyMultiValuesMatcher size(int value) {
        return new SizeBodyMatcher(value);
    }

    @Override
    public void match(Object[] values) {
        assertThat(values).hasSize(size);
    }
}
