package com.example.scaffold.frameworks.test.web;

public abstract class BodyCastStringMatcher extends BodyCastTypeMatcher<String> {
    protected abstract void realMatch(String value);

    @Override
    protected Class<String> typeClass() {
        return String.class;
    }
}
