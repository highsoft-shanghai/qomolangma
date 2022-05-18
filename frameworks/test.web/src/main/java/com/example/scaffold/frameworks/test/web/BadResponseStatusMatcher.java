package com.example.scaffold.frameworks.test.web;

import org.springframework.http.HttpStatus;

public final class BadResponseStatusMatcher extends ResponseStatusMatcher {
    private BadResponseStatusMatcher() {
        super(HttpStatus.BAD_REQUEST);
    }

    public static BadResponseStatusMatcher badStatus() {
        return new BadResponseStatusMatcher();
    }
}
