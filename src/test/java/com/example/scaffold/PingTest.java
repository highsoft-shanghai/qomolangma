package com.example.scaffold;

import com.example.scaffold.frameworks.test.web.IntegrationTest;
import com.example.scaffold.frameworks.test.web.RestTestTemplate;
import com.example.scaffold.frameworks.test.web.TestResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import javax.annotation.Resource;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@IntegrationTest
public class PingTest {
    private @Resource RestTestTemplate testTemplate;

    @Test
    void should_reply_pong() {
        TestResponse testResponse = testTemplate.post("/ping", Map.of("data", "pong"));
        assertThat(testResponse.statusCode()).isEqualTo(HttpStatus.OK);
        assertThat(testResponse.<String>value("$")).isEqualTo("pong");
    }
}
