package com.qomolangma.frameworks.test.web;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;

public class RestTestTest extends IntegrationTest {

    @Test
    void should_be_able_to_call_simple_get() {
        ValidatableResponse response = get("/web-test/simple-get");
        response.statusCode(is(200)).body("name", is("John"));
    }

}
