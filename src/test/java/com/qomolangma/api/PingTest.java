package com.qomolangma.api;

import com.qomolangma.frameworks.test.web.IntegrationTest;
import com.qomolangma.frameworks.test.web.PathVariables;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.Matchers.is;

public class PingTest extends IntegrationTest {
    @Test
    void should_reply_pong() {
        ValidatableResponse post = post("/ping", PathVariables.variables(Map.of()), Map.of("data", "pong"), null);
        post.statusCode(is(200)).body("ping", is("pong")).body("message", is("ok"));
    }
}
