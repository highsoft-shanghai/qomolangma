package com.qomolangma.frameworks.payload.core;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class SetFieldType<T> extends FieldType<Set<T>> {

    private final FieldType<T> elementType;

    public SetFieldType(FieldType<T> elementType) {
        this.elementType = elementType;
    }

    public SetFieldType<T> nullToEmpty() {
        setNullHandler(Collections::emptySet);
        return this;
    }

    @Override
    protected boolean match(Class<?> underlyingType) {
        return Set.class.isAssignableFrom(underlyingType);
    }

    @Override
    protected Set<T> convert(Object value) {
        return ((Set<?>) value).stream().map(elementType::from).collect(Collectors.toSet());
    }
}
