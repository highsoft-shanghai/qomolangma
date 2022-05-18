package com.example.scaffold.frameworks.test.web;

import org.springframework.http.HttpStatus;

public final class OkResponseStatusMatcher extends ResponseStatusMatcher {
    private OkResponseStatusMatcher() {
        super(HttpStatus.OK);
    }

    public static ResponseStatusMatcher okStatus() {
        return new OkResponseStatusMatcher();
    }
}
