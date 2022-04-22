package com.example.scaffold;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PingTest extends IntegrationTest {
    @Test
    void should_reply_pong() {
        TestResponse testResponse = post("/ping", Map.of("data", "pong"));
        assertThat(testResponse.statusCode()).isEqualTo(HttpStatus.OK);
        assertThat(testResponse.<String>value("$")).isEqualTo("pong");
    }
}
