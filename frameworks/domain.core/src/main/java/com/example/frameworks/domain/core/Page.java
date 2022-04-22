package com.example.frameworks.domain.core;

import java.util.List;
import java.util.function.Function;

public interface Page<T> {
    List<T> getContent();
    long getTotalElements();
    int getSize();
    int getNumber();
    int getNumberOfElements();
    <U> Page<U> map(Function<? super T, ? extends U> converter);
}
