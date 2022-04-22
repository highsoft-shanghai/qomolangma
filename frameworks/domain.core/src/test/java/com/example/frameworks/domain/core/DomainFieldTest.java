package com.example.frameworks.domain.core;

import org.junit.jupiter.api.*;

import static com.example.frameworks.domain.core.StringFieldType.asString;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DomainFieldTest {

    private TestUser john;

    @BeforeEach
    void setUp() {
        john = new TestUser("John");
    }

    @Test
    void should_be_able_to_create_domain_field_when_giving_domain_field() {
        assertEquals(john.getName(), "John");
    }

    @Test
    void should_be_able_to_set_user_name() {
        john.setName("Neil");
        assertEquals(john.getName(), "Neil");
    }

    static class TestUser extends DomainField<String> {

        public TestUser(String value) {
            super(value, asString());
        }

        public String getName() {
            return super.get();
        }

        public void setName(String name) {
            super.set(name);
        }

    }

}
