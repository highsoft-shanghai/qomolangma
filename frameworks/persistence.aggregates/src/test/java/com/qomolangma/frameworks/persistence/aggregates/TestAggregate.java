package com.qomolangma.frameworks.persistence.aggregates;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
public class TestAggregate {

    private final String name;

    public String name() {
        return name;
    }

}
