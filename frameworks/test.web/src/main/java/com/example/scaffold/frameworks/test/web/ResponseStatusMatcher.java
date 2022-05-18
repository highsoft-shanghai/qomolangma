package com.example.scaffold.frameworks.test.web;

import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResponseStatusMatcher {
    private final HttpStatus status;

    public ResponseStatusMatcher(HttpStatus status) {
        this.status = status;
    }

    public void match(TestResponse response) {
        assertEquals(response.statusCode(), status);
    }
}
