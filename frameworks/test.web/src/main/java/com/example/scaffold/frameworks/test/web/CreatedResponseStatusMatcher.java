package com.example.scaffold.frameworks.test.web;

import org.springframework.http.HttpStatus;

public final class CreatedResponseStatusMatcher extends ResponseStatusMatcher {
    private CreatedResponseStatusMatcher() {
        super(HttpStatus.CREATED);
    }

    public static CreatedResponseStatusMatcher createdStatus() {
        return new CreatedResponseStatusMatcher();
    }
}
