package com.example.scaffold.frameworks.test.web;

import org.springframework.http.HttpStatus;

public final class NotFoundResponseStatusMatcher extends ResponseStatusMatcher {
    NotFoundResponseStatusMatcher() {
        super(HttpStatus.NOT_FOUND);
    }
}
