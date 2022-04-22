package com.example.frameworks.domain.core;

public class DomainField<T> {

    private T value;

    public DomainField(T value, FieldType<T> fieldType) {
        this.value = new Payload(value).get(fieldType);
    }

    protected T get() {
        return value;
    }

    protected void set(T value) {
        this.value = value;
    }

}
