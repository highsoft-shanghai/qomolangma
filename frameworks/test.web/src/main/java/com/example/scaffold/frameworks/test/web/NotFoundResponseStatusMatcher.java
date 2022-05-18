package com.example.scaffold.frameworks.test.web;

import org.springframework.http.HttpStatus;

public final class NotFoundResponseStatusMatcher extends ResponseStatusMatcher {
    private NotFoundResponseStatusMatcher() {
        super(HttpStatus.NOT_FOUND);
    }

    public static NotFoundResponseStatusMatcher notFoundStatus() {
        return new NotFoundResponseStatusMatcher();
    }
}
