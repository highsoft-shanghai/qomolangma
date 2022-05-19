package com.example.scaffold.frameworks.test.web;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public final class ExistResponseHeaderMatcher extends SingleValueConstructResponseHeaderMatcher {
    ExistResponseHeaderMatcher(String value) {
        super(value);
    }

    @Override
    public void match(List<String> headerValues) {
        assertThat(headerValues).contains(value());
    }
}
