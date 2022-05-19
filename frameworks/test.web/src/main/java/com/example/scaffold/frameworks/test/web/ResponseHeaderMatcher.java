package com.example.scaffold.frameworks.test.web;

import java.util.List;

public interface ResponseHeaderMatcher {
    static ResponseHeaderMatcher exist(String value) {
        return new ExistResponseHeaderMatcher(value);
    }
    void match(List<String> headerValues);
}
