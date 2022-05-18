package com.example.scaffold.frameworks.test.web;

public abstract class BodyCastIntegerMatcher extends BodyCastTypeMatcher {
    @Override
    protected Class<?> typeClass() {
        return Integer.class;
    }
}
