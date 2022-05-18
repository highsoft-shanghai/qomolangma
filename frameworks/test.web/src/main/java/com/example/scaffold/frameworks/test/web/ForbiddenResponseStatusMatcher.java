package com.example.scaffold.frameworks.test.web;

import org.springframework.http.HttpStatus;

public final class ForbiddenResponseStatusMatcher extends ResponseStatusMatcher {
    ForbiddenResponseStatusMatcher() {
        super(HttpStatus.FORBIDDEN);
    }
}
