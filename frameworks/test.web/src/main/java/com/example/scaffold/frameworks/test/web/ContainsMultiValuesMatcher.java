package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class ContainsMultiValuesMatcher implements ResponseBodyMultiValuesMatcher {
    private final Object[] matchValues;

    ContainsMultiValuesMatcher(Object... matchValues) {
        this.matchValues = matchValues;
    }

    @Override
    public void match(Object[] values) {
        assertThat(values).contains(matchValues);
    }
}
