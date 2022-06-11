package com.everest.frameworks.test.persistence;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InstancesTest {

    @Test
    void should_be_able_to_throw_persistence_exception_when_type_mismatch() {
        assertThrows(PersistenceException.class, () -> new Instances(List.of()).type(TestClass.class.getDeclaredField("name")),
            "Error! The type is not register in Persistence:java.lang.String. You need to check if the type is valid. If it is a new persistence template, you can add it to Persistence in frameworks.test.persistence.");
    }

    private static class TestClass {

        private String name;

    }

}
