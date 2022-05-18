package com.example.scaffold.frameworks.test.web;

import org.springframework.http.HttpStatus;

public final class EqStatusMatcher extends ResponseStatusMatcher {
    private EqStatusMatcher(HttpStatus status) {
        super(status);
    }

    public static ResponseStatusMatcher eq(HttpStatus status) {
        return new EqStatusMatcher(status);
    }
}
