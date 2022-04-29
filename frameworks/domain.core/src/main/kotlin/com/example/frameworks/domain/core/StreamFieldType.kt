package com.example.frameworks.domain.core;

import java.util.List;
import java.util.stream.Stream;

public class StreamFieldType<T> extends FieldType<Stream<T>> {
    private final FieldType<T> elementType;

    public StreamFieldType(FieldType<T> elementType) {
        this.elementType = elementType;
    }

    @Override
    protected boolean match(Class<?> underlyingType) {
        return List.class.isAssignableFrom(underlyingType);
    }

    @Override
    protected Stream<T> convert(Object value) {
        return ((List<?>) value).stream().map(elementType::from);
    }

    public StreamFieldType<T> nullToEmpty() {
        setNullHandler(Stream::empty);
        return this;
    }
}
