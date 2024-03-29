package com.qomolangma.frameworks.persistence.spring;

import com.qomolangma.frameworks.domain.core.SortOrder;

import java.util.Iterator;

public class SpringSortOrderIterator implements Iterator<SortOrder> {

    private final Iterator<org.springframework.data.domain.Sort.Order> impl;

    public static Iterator<SortOrder> of(Iterator<org.springframework.data.domain.Sort.Order> impl) {
        return new SpringSortOrderIterator(impl);
    }

    protected SpringSortOrderIterator(Iterator<org.springframework.data.domain.Sort.Order> impl) {
        this.impl = impl;
    }

    @Override
    public boolean hasNext() {
        return impl.hasNext();
    }

    @Override
    public SortOrder next() {
        return SpringSortOrder.of(impl.next());
    }

}
