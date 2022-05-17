package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public class ContainsMultiValuesMatcher implements ResponseBodyMultiValuesMatcher {
    private final Object[] matchValues;

    public ContainsMultiValuesMatcher(Object... matchValues) {
        this.matchValues = matchValues;
    }

    public static ResponseBodyMultiValuesMatcher contains(Object... matchValues) {
        return new ContainsMultiValuesMatcher(matchValues);
    }

    @Override
    public void match(Object[] values) {
        assertThat(values).contains(matchValues);
    }
}
