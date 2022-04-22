package com.example.frameworks.domain.core;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Supplier;

public abstract class FieldType<T> {

    private Supplier<T> nullHandler = this::defaultNullHandler;

    public FieldType<T> allowNull() {
        this.nullHandler = () -> null;
        return this;
    }

    public ArrayFieldType<T> array() {
        return new ArrayFieldType<>(this);
    }

    public StreamFieldType<T> stream() {
        return new StreamFieldType<>(this);
    }

    protected T from(@Nullable Object value) {
        if (value == null) return nullHandler.get();
        Class<?> aClass = value.getClass();
        if (!match(aClass)) throw new MalformedPayloadException("error.request.field-type-mismatch");
        T result = convert(value);
        validate(result);
        return result;
    }

    protected final void setNullHandler(Supplier<T> nullHandler) {
        this.nullHandler = nullHandler;
    }

    protected T defaultNullHandler() {
        throw new MalformedPayloadException("error.request.missing-field");
    }

    protected abstract boolean match(Class<?> underlyingType);

    protected abstract T convert(Object value);

    protected void validate(T value) {
    }

}
