package com.example.scaffold.frameworks.test.web;

import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

public interface ResponseMatcher {
    void match(TestResponse response);

    static ResponseMatcher body(String jsonPath, ResponseBodyMatcher matcher) {
        return o -> matcher.match(o.value(jsonPath));
    }

    static ResponseMatcher textBody(Object value) {
        return o -> assertEquals(o.textBody(), value);
    }

    static ResponseMatcher ok() {
        return o -> statusCode(HttpStatus.OK).match(o);
    }

    static ResponseMatcher created() {
        return o -> statusCode(HttpStatus.CREATED).match(o);
    }

    static ResponseMatcher bad() {
        return o -> statusCode(HttpStatus.BAD_REQUEST).match(o);
    }

    static ResponseMatcher error() {
        return o -> statusCode(HttpStatus.INTERNAL_SERVER_ERROR).match(o);
    }

    static ResponseMatcher statusCode(HttpStatus status) {
        return o -> assertEquals(status, o.statusCode());
    }
}
