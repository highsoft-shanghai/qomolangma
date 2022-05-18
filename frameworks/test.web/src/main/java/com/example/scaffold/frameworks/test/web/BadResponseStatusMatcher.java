package com.example.scaffold.frameworks.test.web;

import org.springframework.http.HttpStatus;

public final class BadResponseStatusMatcher extends ResponseStatusMatcher {
    BadResponseStatusMatcher() {
        super(HttpStatus.BAD_REQUEST);
    }
}
