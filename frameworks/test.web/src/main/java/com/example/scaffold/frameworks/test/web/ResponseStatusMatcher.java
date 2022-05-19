package com.example.scaffold.frameworks.test.web;

import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResponseStatusMatcher {
    private final HttpStatus status;

    public ResponseStatusMatcher(HttpStatus status) {
        this.status = status;
    }

    public static ResponseStatusMatcher bad() {
        return new BadResponseStatusMatcher();
    }

    public static ResponseStatusMatcher created() {
        return new CreatedResponseStatusMatcher();
    }

    public static ResponseStatusMatcher statusCode(HttpStatus status) {
        return new EqStatusMatcher(status);
    }

    public static ResponseStatusMatcher error() {
        return new ErrorResponseStatusMatcher();
    }

    public static ResponseStatusMatcher forbidden() {
        return new ForbiddenResponseStatusMatcher();
    }

    public static ResponseStatusMatcher notFound() {
        return new NotFoundResponseStatusMatcher();
    }

    public static ResponseStatusMatcher ok() {
        return new OkResponseStatusMatcher();
    }

    public static ResponseStatusMatcher unauthorized() {
        return new UnauthorizedResponseStatusMatcher();
    }

    public void match(TestResponse response) {
        assertEquals(response.statusCode(), status);
    }
}
