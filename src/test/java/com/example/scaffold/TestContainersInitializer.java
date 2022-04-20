package com.example.scaffold;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.*;
import org.springframework.stereotype.Component;
import org.testcontainers.containers.MariaDBContainer;

import java.util.stream.Stream;

@Slf4j
@Component
public class TestContainersInitializer implements BeforeAllCallback {

    private static MariaDBContainer<?> mysqldb;

    @Override
    public void beforeAll(ExtensionContext context) {
        log.info("Starting test containers...");
        Stream.of((Runnable) this::startMySQL).parallel().forEach(Runnable::run);
    }

    private void startMySQL() {
        if (mysqldb != null) return;
        mysqldb = new MariaDBContainer<>("mariadb:10.5.8");
        mysqldb.start();
        // TODO : Change it.
        System.setProperty("SCAFFOLD_URL", mysqldb.getJdbcUrl());
    }

    public boolean isRunning() {
        return mysqldb.isRunning();
    }

}
