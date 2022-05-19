package com.example.scaffold.frameworks.test.web;

public abstract class SingleValueConstructBodyCastComparableMatcher<T extends Comparable<T>> extends BodyCastComparableMatcher<T> {
    private final T value;

    public SingleValueConstructBodyCastComparableMatcher(T value) {
        this.value = value;
    }

    protected T value() {
        return value;
    }
}
