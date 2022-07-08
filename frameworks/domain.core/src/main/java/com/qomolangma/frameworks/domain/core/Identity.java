package com.qomolangma.frameworks.domain.core;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Identity {
    private final String id;
    private final String name;

    public Identity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Identity get() {
        return new Identity(this.id, this.name);
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

}
