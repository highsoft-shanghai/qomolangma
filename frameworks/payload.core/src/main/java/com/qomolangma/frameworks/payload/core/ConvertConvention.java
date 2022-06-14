package com.qomolangma.frameworks.payload.core;

import java.util.function.Function;

public final class ConvertConvention<D> {
    private final String name;
    private final Function<D, Object> function;

    private ConvertConvention(String name, Function<D, Object> function) {
        this.name = name;
        this.function = function;
    }

    public static <D> ConvertConvention<D> convention(String name, Function<D, Object> function) {
        return new ConvertConvention<>(name, function);
    }

    public Object apply(D d) {
        return function.apply(d);
    }

    public String name() {
        return name;
    }
}
