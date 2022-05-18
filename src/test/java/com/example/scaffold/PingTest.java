package com.example.scaffold;

import com.example.scaffold.frameworks.test.web.IntegrationTest;
import com.example.scaffold.frameworks.test.web.TestRequestTemplate;
import com.example.scaffold.frameworks.test.web.TestResponse;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.Map;

import static com.example.scaffold.frameworks.test.web.ResponseBodyMatcher.eq;
import static com.example.scaffold.frameworks.test.web.ResponseMatcher.body;
import static com.example.scaffold.frameworks.test.web.ResponseMatcher.ok;

@IntegrationTest
public class PingTest {
    private @Resource TestRequestTemplate testTemplate;

    @Test
    void should_reply_pong() {
        TestResponse testResponse = testTemplate.post("/ping", Map.of("data", "pong"));
        testResponse.is(ok()).is(body("$", eq("pong")));
    }
}
