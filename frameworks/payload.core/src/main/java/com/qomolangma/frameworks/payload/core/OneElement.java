package com.qomolangma.frameworks.payload.core;

import java.util.Map;

public class OneElement<D> {
    private final ConvertRules<D> conventions;

    @SafeVarargs
    public OneElement(ConvertRule<D>... conventions) {
        this.conventions = new ConvertRules<>(conventions);
    }

    @SafeVarargs
    public static <D> OneElement<D> one(ConvertRule<D>... conventions) {
        return new OneElement<>(conventions);
    }

    public Map<String, Object> transform(D d) {
        return conventions.convert(d);
    }
}
