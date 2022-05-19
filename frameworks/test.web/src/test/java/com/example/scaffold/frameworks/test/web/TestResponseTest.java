package com.example.scaffold.frameworks.test.web;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import javax.annotation.Resource;

import static com.example.scaffold.frameworks.test.web.ResponseBodyMatcher.*;
import static com.example.scaffold.frameworks.test.web.ResponseBodyMultiValuesMatcher.*;
import static com.example.scaffold.frameworks.test.web.ResponseMatcher.body;
import static com.example.scaffold.frameworks.test.web.ResponseMatcher.textBody;
import static com.example.scaffold.frameworks.test.web.ResponseStatusMatcher.*;

@IntegrationTest
public class TestResponseTest {
    private @Resource TestRequestTemplate restTemplate;

    @Test
    void should_be_able_to_validate_ok_and_body_eq_when_giving_right_json_rest_api_request() {
        restTemplate.get("/test").statusCodeIs(statusCode(HttpStatus.OK));
        restTemplate.get("/test").statusCodeIs(ok())
                .is(body("$.list", size(3)))
                .is(body("$.list", contains("1", "2")))
                .is(body("$.list", containsExactly("1", "2", "3")))
                .is(body("$.list", containsExactlyInAnyOrder("1", "2", "3")))
                .is(body("$.id", isNotNull()))
                .is(body("$.id", eq("123")))
                .is(body("$.id", isNotEmpty()))
                .is(body("$.empty", isEmpty()))
                .is(body("$.id", hasSize(3)))
                .is(body("$.id", notEq("1234")))
                .is(body("$.null", isNull()))
                .is(body("$.null", isNullOrEmpty()))
                .is(body("$.empty", isNullOrEmpty()))
                .is(body("$.num", isGreaterThan(0)))
                .is(body("$.num", isGreaterThanOrEqualTo(1)))
                .is(body("$.num", isLessThan(2)))
                .is(body("$.num", isLessThanOrEqualTo(1)))
                .is(body("$.num", isPositive()))
                .is(body("$.num", isNotNegative()))
                .is(body("$.num", isOdd()))
                .is(body("$.num", isOne()))
                .is(body("$.num2", isNegative()))
                .is(body("$.num2", isNotPositive()))
                .is(body("$.num2", isEven()))
                .is(body("$.num2", isNotZero()))
                .is(body("$.num3", isZero()))
                .is(body("$.true", isTrue()))
                .is(body("$.false", isFalse()))
                .is(body("$.long", isGreaterThan(1L)));
    }

    @Test
    void should_be_able_to_test_is_negative_and_is_not_positive() {
        restTemplate.get("/test").statusCodeIs(ok())
                .is(body("$.num2", isNegative()))
                .is(body("$.num2", isNotPositive()))
                .is(body("$.long2", isNegative()))
                .is(body("$.long2", isNotPositive()))
                .is(body("$.double", isNegative()))
                .is(body("$.double", isNotPositive()))
                .is(body("$.short", isNegative()))
                .is(body("$.short", isNotPositive()));
    }

    @Test
    void should_be_able_to_validate_bad_request_when_giving_bad_request() {
        restTemplate.get("/test/bad").statusCodeIs(bad());
    }

    @Test
    void should_be_able_to_validate_bad_request_when_giving_error_request() {
        restTemplate.get("/test/error").statusCodeIs(error());
    }

    @Test
    void should_be_able_to_validate_bad_request_when_giving_created() {
        restTemplate.get("/test/created").statusCodeIs(created()).is(textBody(eq("ok")));
    }

    @Test
    void should_be_able_to_validate_not_found_request_when_giving_not_found_path() {
        restTemplate.get("/test/not-found-path").statusCodeIs(notFound());
    }

    @Test
    void should_be_able_to_validate_forbidden_request_when_giving_forbidden_path() {
        restTemplate.get("/test/forbidden").statusCodeIs(forbidden());
    }

    @Test
    void should_be_able_to_validate_unauthorized_request_when_giving_unauthorized_path() {
        restTemplate.get("/test/unauthorized").statusCodeIs(unauthorized());
    }
}
