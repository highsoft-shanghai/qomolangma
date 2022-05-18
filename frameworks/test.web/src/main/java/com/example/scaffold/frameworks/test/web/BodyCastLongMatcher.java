package com.example.scaffold.frameworks.test.web;

public abstract class BodyCastLongMatcher extends BodyCastTypeMatcher {
    @Override
    protected Class<?> typeClass() {
        return Long.class;
    }
}
