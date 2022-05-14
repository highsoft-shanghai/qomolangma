package com.example.scaffold.frameworks.persistence.spring;

import com.example.frameworks.domain.core.Page;
import com.example.frameworks.domain.core.Sort;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Function;

public class SpringPage<T> implements Page<T> {

    private final org.springframework.data.domain.Page<T> impl;

    public static <T> SpringPage<T> from(org.springframework.data.domain.Page<T> page) {
        return new SpringPage<>(page);
    }

    protected SpringPage(org.springframework.data.domain.Page<T> impl) {
        this.impl = impl;
    }

    @Override
    public @NotNull List<T> content() {
        return impl.getContent();
    }

    @Override
    public int size() {
        return impl.getSize();
    }

    @Override
    public int number() {
        return impl.getNumber();
    }

    @Override
    public int numberOfElements() {
        return impl.getNumberOfElements();
    }

    @Override
    public int numberOfTotalPages() {
        return impl.getTotalPages();
    }

    @Override
    public long numberOfTotalElements() {
        return impl.getTotalElements();
    }

    @Override
    public boolean first() {
        return impl.isFirst();
    }

    @Override
    public boolean last() {
        return impl.isLast();
    }

    @Override
    public @NotNull Sort sort() {
        return SpringSort.of(impl.getSort());
    }

    @Override
    public @NotNull <U> Page<U> map(Function<? super T, ? extends U> converter) {
        return new SpringPage<>(impl.map(converter));
    }

}
