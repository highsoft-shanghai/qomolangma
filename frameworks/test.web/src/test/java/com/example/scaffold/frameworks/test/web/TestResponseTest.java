package com.example.scaffold.frameworks.test.web;

import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import static com.example.scaffold.frameworks.test.web.ContainsMultiValuesMatcher.contains;
import static com.example.scaffold.frameworks.test.web.EqBodyMatcher.eq;
import static com.example.scaffold.frameworks.test.web.NotEqBodyMatcher.notEq;
import static com.example.scaffold.frameworks.test.web.NotNullBodyMatcher.isNotNull;
import static com.example.scaffold.frameworks.test.web.NullBodyMatcher.isNull;
import static com.example.scaffold.frameworks.test.web.ResponseMatcher.*;
import static com.example.scaffold.frameworks.test.web.SizeBodyMatcher.size;

@IntegrationTest
public class TestResponseTest {
    private @Resource TestRequestTemplate restTemplate;

    @Test
    void should_be_able_to_validate_ok_and_body_eq_when_giving_right_json_rest_api_request() {
        TestResponse response = restTemplate.get("/test");
        response.is(ok())
                .is(body("$.list", size(3)))
                .is(body("$.list", contains("1", "2")))
                .is(body("$.id", isNotNull()))
                .is(body("$.id", eq("123")))
                .is(body("$.id", notEq("1234")))
                .is(textBody(eq("{\"null\":null,\"id\":\"123\",\"list\":[\"1\",\"2\",\"3\"]}")))
                .is(body("$.null", isNull()));
    }

    @Test
    void should_be_able_to_validate_bad_request_when_giving_bad_request() {
        TestResponse response = restTemplate.get("/test/bad");
        response.is(bad());
    }

    @Test
    void should_be_able_to_validate_bad_request_when_giving_error_request() {
        TestResponse response = restTemplate.get("/test/error");
        response.is(error());
    }

    @Test
    void should_be_able_to_validate_bad_request_when_giving_created() {
        TestResponse response = restTemplate.get("/test/created");
        response.is(created());
    }
}
