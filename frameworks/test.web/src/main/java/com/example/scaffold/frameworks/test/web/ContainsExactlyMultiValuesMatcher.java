package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class ContainsExactlyMultiValuesMatcher implements ResponseBodyMultiValuesMatcher {
    private final Object[] matchValues;

    public static ContainsExactlyMultiValuesMatcher containsExactly(Object... matchValues) {
        return new ContainsExactlyMultiValuesMatcher(matchValues);
    }

    private ContainsExactlyMultiValuesMatcher(Object... matchValues) {
        this.matchValues = matchValues;
    }

    @Override
    public void match(Object... values) {
        assertThat(values).containsExactly(matchValues);
    }

}
