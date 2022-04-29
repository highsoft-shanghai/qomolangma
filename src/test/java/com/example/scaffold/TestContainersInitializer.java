package com.example.scaffold;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Slf4j
@Component
public class TestContainersInitializer implements BeforeAllCallback {
    @Override
    public void beforeAll(ExtensionContext context) {
        log.info("Starting test containers...");
        Stream.of((Runnable) this::startMySQL).parallel().forEach(Runnable::run);
    }

    private void startMySQL() {
    }

    public boolean isRunning() {
        return true;
    }
}
