package com.example.scaffold.frameworks.test.web;

import org.springframework.http.HttpStatus;

public final class EqStatusMatcher extends ResponseStatusMatcher {
    EqStatusMatcher(HttpStatus status) {
        super(status);
    }
}
