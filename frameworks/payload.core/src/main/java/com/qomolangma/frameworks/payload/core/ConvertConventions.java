package com.qomolangma.frameworks.payload.core;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertConventions<D> {
    private final List<ConvertConvention<D>> conventions;

    @SafeVarargs
    public ConvertConventions(ConvertConvention<D>... conventions) {
        this.conventions = List.of(conventions);
    }

    public List<ConvertConvention<D>> conventions() {
        return conventions;
    }

    public Map<String, Object> convert(D d) {
        return this.conventions().stream().collect(Collectors.toMap(ConvertConvention::name, c -> c.apply(d), (o1, o2) -> o2, LinkedHashMap::new));
    }
}
