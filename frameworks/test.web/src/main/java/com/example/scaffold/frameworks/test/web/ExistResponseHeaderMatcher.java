package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class ExistResponseHeaderMatcher extends SingleValueConstructResponseHeaderMatcher {
    ExistResponseHeaderMatcher(String value) {
        super(value);
    }

    @Override
    public void match(TestResponse response, String header) {
        assertThat(response.header(header)).contains(value());
    }
}
