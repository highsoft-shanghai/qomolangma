package com.example.scaffold.frameworks.test.web;

public abstract class BodyCastBooleanMatcher extends BodyCastTypeMatcher {
    @Override
    protected Class<?> typeClass() {
        return Boolean.class;
    }
}
