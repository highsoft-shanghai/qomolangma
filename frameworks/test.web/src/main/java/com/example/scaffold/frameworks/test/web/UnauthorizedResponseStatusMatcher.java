package com.example.scaffold.frameworks.test.web;

import org.springframework.http.HttpStatus;

public final class UnauthorizedResponseStatusMatcher extends ResponseStatusMatcher {
    private UnauthorizedResponseStatusMatcher() {
        super(HttpStatus.UNAUTHORIZED);
    }

    public static UnauthorizedResponseStatusMatcher unauthorizedStatus() {
        return new UnauthorizedResponseStatusMatcher();
    }
}
