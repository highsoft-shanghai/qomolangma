package com.qomolangma.frameworks.payload.core;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertRules<D> {
    private final List<ConvertRule<D>> conventions;

    @SafeVarargs
    public ConvertRules(ConvertRule<D>... conventions) {
        this.conventions = List.of(conventions);
    }

    public List<ConvertRule<D>> conventions() {
        return conventions;
    }

    public Map<String, Object> convert(D d) {
        return this.conventions().stream().collect(Collectors.toMap(ConvertRule::name, c -> c.apply(d), (o1, o2) -> o2, LinkedHashMap::new));
    }
}
