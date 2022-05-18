package com.example.scaffold.frameworks.test.web;

public abstract class ComparableBodyCastIntegerMatcher extends BodyCastIntegerMatcher {
    private final Integer value;


    public ComparableBodyCastIntegerMatcher(Integer value) {
        this.value = value;
    }

    protected Integer value() {
        return value;
    }
}
