package com.everest.frameworks.test.moco;

import com.everest.frameworks.test.container.WithTestContainers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.github.dreamhead.moco.Moco.by;
import static com.github.dreamhead.moco.Moco.uri;
import static com.github.dreamhead.moco.MocoRequestHit.times;
import static org.junit.jupiter.api.Assertions.assertEquals;

@WithTestContainers(containers = {MocoContainer.class})
public class MocoContainerTest {
    private Connection connection;

    @BeforeEach
    void setUp() throws IOException {
        connection = Connection.by(System.getProperty("moco.url") + "/ping");
    }

    @Test
    void should_be_able_to_start_one_moco_container_at_target_port() throws IOException {
        connection.connect();
        assertEquals(connection.responseCode(), 200);
        assertEquals(connection.responseBody(), "pong");
        MocoValidation.hit().verify(by(uri("/ping")), times(1));
    }

    @AfterEach
    void tearDown() {
        connection.disconnect();
    }
}
