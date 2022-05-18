package com.example.scaffold.frameworks.test.web;

import org.springframework.http.HttpStatus;

public final class UnauthorizedResponseStatusMatcher extends ResponseStatusMatcher {
    UnauthorizedResponseStatusMatcher() {
        super(HttpStatus.UNAUTHORIZED);
    }
}
