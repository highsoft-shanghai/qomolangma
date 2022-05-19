package com.example.scaffold.frameworks.test.web;

public interface ResponseMatcher {
    void match(TestResponse response);

    static ResponseMatcher body(String jsonPath, ResponseBodyMatcher<?> matcher) {
        return o -> matcher.match(o.value(jsonPath));
    }

    static ResponseMatcher body(String jsonPath, ResponseBodyMultiValuesMatcher matcher) {
        return o -> matcher.match(o.values(jsonPath));
    }

    static ResponseMatcher textBody(ResponseBodyMatcher<Object> matcher) {
        return o -> matcher.match(o.textBody());
    }

    static ResponseMatcher header(String header, ResponseHeaderMatcher matcher) {
        return response -> matcher.match(response, header);
    }
}
