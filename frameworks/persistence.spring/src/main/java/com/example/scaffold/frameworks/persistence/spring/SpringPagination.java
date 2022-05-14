package com.example.scaffold.frameworks.persistence.spring;

import com.example.frameworks.domain.core.Pagination;
import com.example.frameworks.domain.core.Sort;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class SpringPagination implements Pagination {

    private final Pageable impl;

    public static Pagination of(PageRequest impl) {
        return new SpringPagination(impl);
    }

    protected SpringPagination(Pageable pageable) {
        this.impl = pageable;
    }

    @Override
    public int pageNumber() {
        return impl.getPageNumber();
    }

    @Override
    public int pageSize() {
        return impl.getPageSize();
    }

    @Override
    public @NotNull Sort sort() {
        return SpringSort.of(impl.getSort());
    }

}
