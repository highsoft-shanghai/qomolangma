package com.example.scaffold.frameworks.test.web;

import static com.example.scaffold.frameworks.test.web.ResponseStatusMatcher.badStatus;
import static com.example.scaffold.frameworks.test.web.ResponseStatusMatcher.createdStatus;
import static com.example.scaffold.frameworks.test.web.ResponseStatusMatcher.errorStatus;
import static com.example.scaffold.frameworks.test.web.ResponseStatusMatcher.forbiddenStatus;
import static com.example.scaffold.frameworks.test.web.ResponseStatusMatcher.notFoundStatus;
import static com.example.scaffold.frameworks.test.web.ResponseStatusMatcher.okStatus;
import static com.example.scaffold.frameworks.test.web.ResponseStatusMatcher.unauthorizedStatus;

public interface ResponseMatcher {
    void match(TestResponse response);

    static ResponseMatcher body(String jsonPath, ResponseBodyMatcher matcher) {
        return o -> matcher.match(o.value(jsonPath));
    }

    static ResponseMatcher body(String jsonPath, ResponseBodyMultiValuesMatcher matcher) {
        return o -> matcher.match(o.values(jsonPath));
    }

    static ResponseMatcher textBody(ResponseBodyMatcher matcher) {
        return o -> matcher.match(o.textBody());
    }

    /**
     * Validate response status is {@link org.springframework.http.HttpStatus#OK}.
     * @return ResponseMatcher
     */
    static ResponseMatcher ok() {
        return statusCode(okStatus());
    }

    /**
     * Validate response status is {@link org.springframework.http.HttpStatus#CREATED}.
     * @return ResponseMatcher
     */
    static ResponseMatcher created() {
        return statusCode(createdStatus());
    }

    /**
     * Validate response status is {@link org.springframework.http.HttpStatus#BAD_REQUEST}.
     * @return ResponseMatcher
     */
    static ResponseMatcher bad() {
        return statusCode(badStatus());
    }

    /**
     * Validate response status is {@link org.springframework.http.HttpStatus#INTERNAL_SERVER_ERROR}.
     * @return ResponseMatcher
     */
    static ResponseMatcher error() {
        return statusCode(errorStatus());
    }

    /**
     * Validate response status is {@link org.springframework.http.HttpStatus#NOT_FOUND}.
     * @return ResponseMatcher
     */
    static ResponseMatcher notFound() {
        return statusCode(notFoundStatus());
    }

    /**
     * Validate response status is {@link org.springframework.http.HttpStatus#UNAUTHORIZED}.
     * @return ResponseMatcher
     */
    static ResponseMatcher unauthorized() {
        return statusCode(unauthorizedStatus());
    }

    /**
     * Validate response status is {@link org.springframework.http.HttpStatus#FORBIDDEN}.
     * @return ResponseMatcher
     */
    static ResponseMatcher forbidden() {
        return statusCode(forbiddenStatus());
    }

    /**
     * Validate response status is expected {@link org.springframework.http.HttpStatus}.
     * @return ResponseMatcher
     */
    static ResponseMatcher statusCode(ResponseStatusMatcher matcher) {
        return matcher::match;
    }
}
