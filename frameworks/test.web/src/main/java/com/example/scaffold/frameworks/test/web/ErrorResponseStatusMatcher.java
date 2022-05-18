package com.example.scaffold.frameworks.test.web;

import org.springframework.http.HttpStatus;

public final class ErrorResponseStatusMatcher extends ResponseStatusMatcher {
    ErrorResponseStatusMatcher() {
        super(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
