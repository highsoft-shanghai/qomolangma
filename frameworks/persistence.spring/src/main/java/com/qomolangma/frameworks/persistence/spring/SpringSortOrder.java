package com.qomolangma.frameworks.persistence.spring;

import com.qomolangma.frameworks.domain.core.SortDirection;
import com.qomolangma.frameworks.domain.core.SortOrder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Sort;

@ToString
@EqualsAndHashCode
public class SpringSortOrder implements SortOrder {

    private final Sort.Order impl;

    public static SortOrder of(Sort.Order impl) {
        return new SpringSortOrder(impl);
    }

    protected SpringSortOrder(Sort.Order impl) {
        this.impl = impl;
    }

    @Override
    public @NotNull String property() {
        return impl.getProperty();
    }

    @Override
    public @NotNull SortDirection direction() {
        return asSortDirection(impl.getDirection());
    }

    private SortDirection asSortDirection(Sort.Direction direction) {
        if (Sort.Direction.DESC.equals(direction)) return SortDirection.DESC;
        return SortDirection.ASC;
    }

}
