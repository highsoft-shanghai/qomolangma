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

    static ResponseMatcher ok() {
        return statusCode(okStatus());
    }

    static ResponseMatcher created() {
        return statusCode(createdStatus());
    }

    static ResponseMatcher bad() {
        return statusCode(badStatus());
    }

    static ResponseMatcher error() {
        return statusCode(errorStatus());
    }

    static ResponseMatcher notFound() {
        return statusCode(notFoundStatus());
    }

    static ResponseMatcher unauthorized() {
        return statusCode(unauthorizedStatus());
    }

    static ResponseMatcher forbidden() {
        return statusCode(forbiddenStatus());
    }

    static ResponseMatcher statusCode(ResponseStatusMatcher matcher) {
        return matcher::match;
    }
}
