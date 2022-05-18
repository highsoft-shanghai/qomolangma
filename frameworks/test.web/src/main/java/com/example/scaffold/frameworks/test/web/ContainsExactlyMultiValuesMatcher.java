package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class ContainsExactlyMultiValuesMatcher implements ResponseBodyMultiValuesMatcher {
    private final Object[] matchValues;

    ContainsExactlyMultiValuesMatcher(Object... matchValues) {
        this.matchValues = matchValues;
    }

    @Override
    public void match(Object... values) {
        assertThat(values).containsExactly(matchValues);
    }

}
