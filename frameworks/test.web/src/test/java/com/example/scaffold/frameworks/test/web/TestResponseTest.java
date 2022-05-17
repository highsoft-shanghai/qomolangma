package com.example.scaffold.frameworks.test.web;

import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import static com.example.scaffold.frameworks.test.web.EqBodyMatcher.eq;
import static com.example.scaffold.frameworks.test.web.ResponseMatcher.body;
import static com.example.scaffold.frameworks.test.web.ResponseMatcher.ok;

@IntegrationTest
public class TestResponseTest {
    private @Resource TestRequestTemplate restTemplate;

    @Test
    void should_be_able_to_validate_ok_and_body_eq_when_giving_right_json_rest_api_request() {
        TestResponse response = restTemplate.get("/test");
        response.is(ok()).is(body("$.id", eq("123")));
    }
}
