package com.example.scaffold.frameworks.test.web;

public interface ResponseHeaderMatcher {
    static ExistResponseHeaderMatcher exist(String value) {
        return new ExistResponseHeaderMatcher(value);
    }
    void match(TestResponse response, String header);
}
