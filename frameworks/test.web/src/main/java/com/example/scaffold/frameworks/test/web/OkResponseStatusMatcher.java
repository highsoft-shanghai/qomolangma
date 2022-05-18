package com.example.scaffold.frameworks.test.web;

import org.springframework.http.HttpStatus;

public final class OkResponseStatusMatcher extends ResponseStatusMatcher {
    OkResponseStatusMatcher() {
        super(HttpStatus.OK);
    }
}
