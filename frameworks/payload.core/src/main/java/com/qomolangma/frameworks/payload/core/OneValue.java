package com.qomolangma.frameworks.payload.core;

import java.util.Map;

public class OneValue<D> {
    private final ConvertConventions<D> conventions;

    @SafeVarargs
    public OneValue(ConvertConvention<D>... conventions) {
        this.conventions = new ConvertConventions<>(conventions);
    }

    @SafeVarargs
    public static <D> OneValue<D> one(ConvertConvention<D>... conventions) {
        return new OneValue<>(conventions);
    }

    public Map<String, Object> transform(D d) {
        return conventions.convert(d);
    }
}
