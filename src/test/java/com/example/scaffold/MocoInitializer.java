package com.example.scaffold;

import com.github.dreamhead.moco.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.*;

import java.lang.Runnable;
import java.util.stream.Stream;

import static com.github.dreamhead.moco.Moco.*;
import static com.github.dreamhead.moco.Runner.runner;

@Slf4j
public class MocoInitializer implements BeforeAllCallback, AfterAllCallback {

    private Runner runner;

    @Override
    public void beforeAll(ExtensionContext context) {
        log.info("Starting moco server...");
        Stream.of((Runnable) this::startMoco).forEach(Runnable::run);
    }

    private void startMoco() {
        if (runner != null) return;
        final HttpServer server = httpServer(9999);
        String baseDir = "src/test/resources/";
        runner = runner(server);
        runner.start();
    }

    @Override
    public void afterAll(ExtensionContext context) {
        runner.stop();
    }

}
