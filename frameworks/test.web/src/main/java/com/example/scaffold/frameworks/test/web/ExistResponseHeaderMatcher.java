package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class ExistResponseHeaderMatcher implements ResponseHeaderMatcher {
    private final String value;

    ExistResponseHeaderMatcher(String value) {
        this.value = value;
    }

    @Override
    public void match(TestResponse response, String header) {
        assertThat(response.header(header)).contains(value);
    }
}
