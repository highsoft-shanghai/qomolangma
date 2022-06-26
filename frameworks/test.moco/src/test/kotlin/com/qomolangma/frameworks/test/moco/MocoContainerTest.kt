package com.qomolangma.frameworks.test.moco;

import com.qomolangma.frameworks.test.container.WithTestContainers;
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
        assertEquals(200, connection.responseCode());
        assertEquals("pong", connection.responseBody());
        MocoHit.hit().verify(by(uri("/ping")), times(1));
    }

    @AfterEach
    void tearDown() {
        connection.disconnect();
    }
}
