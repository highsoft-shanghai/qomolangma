package com.example.scaffold.frameworks.test.web;

public abstract class SingleValueConstructBodyCastIntegerMatcher<T extends Comparable<T>> extends BodyCastComparableMatcher<T> {
    private final T value;

    public SingleValueConstructBodyCastIntegerMatcher(T value) {
        this.value = value;
    }

    protected T value() {
        return value;
    }
}
