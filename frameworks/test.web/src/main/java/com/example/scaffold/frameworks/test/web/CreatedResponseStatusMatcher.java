package com.example.scaffold.frameworks.test.web;

import org.springframework.http.HttpStatus;

public final class CreatedResponseStatusMatcher extends ResponseStatusMatcher {
    CreatedResponseStatusMatcher() {
        super(HttpStatus.CREATED);
    }
}
