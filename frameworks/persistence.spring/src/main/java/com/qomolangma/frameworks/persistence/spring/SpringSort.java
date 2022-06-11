package com.qomolangma.frameworks.persistence.spring;

import com.qomolangma.frameworks.domain.core.Sort;
import com.qomolangma.frameworks.domain.core.SortOrder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@ToString
@EqualsAndHashCode
public class SpringSort implements Sort {

    private final org.springframework.data.domain.Sort impl;

    public static Sort of(org.springframework.data.domain.Sort impl) {
        return new SpringSort(impl);
    }

    protected SpringSort(org.springframework.data.domain.Sort impl) {
        this.impl = impl;
    }

    @Override
    public Iterator<SortOrder> iterator() {
        return SpringSortOrderIterator.of(impl.iterator());
    }

    @Override
    public @NotNull List<SortOrder> orders() {
        return StreamSupport.stream(spliterator(), false).collect(Collectors.toList());
    }

}
