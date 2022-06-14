package com.qomolangma.frameworks.payload.core;

import java.util.function.Function;

public final class ConvertRule<D> {
    private final String name;
    private final Function<D, Object> function;

    private ConvertRule(String name, Function<D, Object> function) {
        this.name = name;
        this.function = function;
    }

    public static <D> ConvertRule<D> rule(String name, Function<D, Object> function) {
        return new ConvertRule<>(name, function);
    }

    public Object apply(D d) {
        return function.apply(d);
    }

    public String name() {
        return name;
    }
}
