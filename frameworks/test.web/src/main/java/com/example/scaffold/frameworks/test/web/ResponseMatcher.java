package com.example.scaffold.frameworks.test.web;

import org.springframework.http.HttpStatus;

import static com.example.scaffold.frameworks.test.web.EqStatusMatcher.eq;

public interface ResponseMatcher {
    void match(TestResponse response);

    static ResponseMatcher body(String jsonPath, ResponseBodyMatcher matcher) {
        return o -> matcher.match(o.value(jsonPath));
    }

    static ResponseMatcher textBody(ResponseBodyMatcher matcher) {
        return o -> matcher.match(o.textBody());
    }

    static ResponseMatcher ok() {
        return o -> statusCode(eq(HttpStatus.OK)).match(o);
    }

    static ResponseMatcher created() {
        return o -> statusCode(eq(HttpStatus.CREATED)).match(o);
    }

    static ResponseMatcher bad() {
        return o -> statusCode(eq(HttpStatus.BAD_REQUEST)).match(o);
    }

    static ResponseMatcher error() {
        return o -> statusCode(eq(HttpStatus.INTERNAL_SERVER_ERROR)).match(o);
    }

    static ResponseMatcher statusCode(ResponseStatusMatcher matcher) {
        return matcher::match;
    }
}
