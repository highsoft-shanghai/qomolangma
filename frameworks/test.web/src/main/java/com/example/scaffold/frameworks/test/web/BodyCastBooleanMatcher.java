package com.example.scaffold.frameworks.test.web;

public abstract class BodyCastBooleanMatcher extends BodyCastTypeMatcher<Boolean> {
    @Override
    protected Class<Boolean> typeClass() {
        return Boolean.class;
    }
}
