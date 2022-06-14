package com.qomolangma.frameworks.payload.core;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static com.qomolangma.frameworks.payload.core.ConvertRule.rule;
import static com.qomolangma.frameworks.payload.core.ListElement.list;
import static com.qomolangma.frameworks.payload.core.OneElement.one;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PayloadInTest {
    @Test
    void should_transform_domain_to_map() {
        TestClass testClass = new TestClass("name", "email");
        Map<String, Object> map = one(rule("name", TestClass::name), rule("email", TestClass::email), rule("email", TestClass::email)).transform(testClass);
        assertEquals("name", map.get("name"));
        assertEquals("email", map.get("email"));
    }

    @Test
    void should_transform_list_domain_to_list_map() {
        List<TestClass> testClasses = List.of(new TestClass("name", "email"), new TestClass("name2", "email2"));
        List<Map<String, Object>> list = list(rule("name", TestClass::name), rule("email", TestClass::email)).transform(testClasses);
        assertThat(list).hasSize(2);
        assertEquals(Map.of("name", "name", "email", "email"), list.get(0));
        assertEquals(Map.of("name", "name2", "email", "email2"), list.get(1));
    }

    private static class TestClass {
        private final String name;
        private final String email;

        private TestClass(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String name() {
            return name;
        }

        public String email() {
            return email;
        }
    }
}
