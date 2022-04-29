package com.example.frameworks.domain.core;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayFieldType<T> extends FieldType<List<T>> {
    private final FieldType<T> elementType;

    public ArrayFieldType(FieldType<T> elementType) {
        this.elementType = elementType;
    }

    public ArrayFieldType<T> nullToEmpty() {
        setNullHandler(Collections::emptyList);
        return this;
    }

    @Override
    protected boolean match(Class<?> underlyingType) {
        return List.class.isAssignableFrom(underlyingType);
    }

    @Override
    protected List<T> convert(Object value) {
        return ((List<?>) value).stream().map(elementType::from).collect(Collectors.toList());
    }
}
