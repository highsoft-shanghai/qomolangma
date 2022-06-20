package com.qomolangma.frameworks.domain.core;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Id {
    private final String id;

    public Id() {
        this(GlobalIdGenerator.nextId());
    }

    public Id(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
