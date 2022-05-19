package com.example.scaffold.frameworks.test.web;

public abstract class SingleValueConstructResponseHeaderMatcher implements ResponseHeaderMatcher {
    private final String value;

    SingleValueConstructResponseHeaderMatcher(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
