package com.qomolangma.frameworks.payload.core;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListElement<D> {
    private final ConvertRules<D> conventions;

    @SafeVarargs
    public ListElement(ConvertRule<D>... conventions) {
        this.conventions = new ConvertRules<>(conventions);
    }

    @SafeVarargs
    public static <D> ListElement<D> list(ConvertRule<D>... conventions) {
        return new ListElement<>(conventions);
    }

    public List<Map<String, Object>> transform(List<D> objects) {
        return objects.stream().map(conventions::convert).collect(Collectors.toList());
    }
}
