package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class ContainsExactlyInAnyOrderMultiValuesMatcher implements ResponseBodyMultiValuesMatcher {

    private final Object[] matchValues;

    ContainsExactlyInAnyOrderMultiValuesMatcher(Object... matchValues) {
        this.matchValues = matchValues;
    }

    @Override
    public void match(Object... values) {
        assertThat(values).containsExactlyInAnyOrder(matchValues);
    }

}
