package com.example.frameworks.domain.core;

import java.util.*;
import java.util.function.Function;

public class EmptyPage<T> implements Page<T> {
    private final List<T> content;
    private final long totalElements;
    private final int size;
    private final int number;
    private final int numberOfElements;

    public EmptyPage() {
        content = new ArrayList<>();
        totalElements = 0;
        size = 0;
        number = 0;
        numberOfElements = 0;
    }

    public EmptyPage<T> of() {
        return new EmptyPage<>();
    }

    @Override
    public List<T> getContent() {
        return this.content;
    }

    @Override
    public long getTotalElements() {
        return totalElements;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getNumberOfElements() {
        return numberOfElements;
    }

    @Override
    public <U> Page<U> map(Function<? super T, ? extends U> converter) {
        return new EmptyPage<>();
    }

}
