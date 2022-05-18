package com.example.scaffold.frameworks.test.web;

public abstract class BodyCastStringMatcher extends BodyCastTypeMatcher {
    protected abstract void realMatch(Object value);

    @Override
    protected Class<?> typeClass() {
        return String.class;
    }
}
