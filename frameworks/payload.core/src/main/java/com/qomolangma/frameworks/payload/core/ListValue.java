package com.qomolangma.frameworks.payload.core;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListValue<D> {
    private final ConvertConventions<D> conventions;

    @SafeVarargs
    public ListValue(ConvertConvention<D>... conventions) {
        this.conventions = new ConvertConventions<>(conventions);
    }

    @SafeVarargs
    public static <D> ListValue<D> list(ConvertConvention<D>... conventions) {
        return new ListValue<>(conventions);
    }

    public List<Map<String, Object>> transform(List<D> objects) {
        return objects.stream().map(conventions::convert).collect(Collectors.toList());
    }
}
