package com.example.scaffold.frameworks.test.web;

import org.springframework.http.HttpStatus;

public final class ForbiddenResponseStatusMatcher extends ResponseStatusMatcher {
    private ForbiddenResponseStatusMatcher() {
        super(HttpStatus.FORBIDDEN);
    }

    public static ForbiddenResponseStatusMatcher forbiddenStatus() {
        return new ForbiddenResponseStatusMatcher();
    }
}
