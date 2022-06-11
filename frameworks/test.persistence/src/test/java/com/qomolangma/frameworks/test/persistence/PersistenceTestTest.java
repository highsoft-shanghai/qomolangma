package com.qomolangma.frameworks.test.persistence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@WithPersistence
public class PersistenceTestTest {
    private TestClient testClient;

    @Test
    void should_be_able_to_run_test_with_persistence_ability() {
        assertNotNull(testClient);
    }
}
