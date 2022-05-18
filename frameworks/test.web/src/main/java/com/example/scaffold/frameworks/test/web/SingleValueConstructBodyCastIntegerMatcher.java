package com.example.scaffold.frameworks.test.web;

public abstract class SingleValueConstructBodyCastIntegerMatcher extends BodyCastComparableMatcher {
    private final Integer value;

    public SingleValueConstructBodyCastIntegerMatcher(Integer value) {
        this.value = value;
    }

    protected Integer value() {
        return value;
    }
}
