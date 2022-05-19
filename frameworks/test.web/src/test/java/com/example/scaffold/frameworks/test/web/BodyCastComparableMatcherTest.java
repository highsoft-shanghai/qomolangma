package com.example.scaffold.frameworks.test.web;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

class BodyCastComparableMatcherTest {
    @Test
    void should_not_use_type_class() {
        assertNull(new TestMatcher().typeClass());
    }

    private static class TestMatcher extends BodyCastComparableMatcher<Integer> {
        @Override
        protected void realMatch(Integer value) {
        }
    }
}
