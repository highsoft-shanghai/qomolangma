package com.example.scaffold.frameworks.persistence.aggregates;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class TestData {
    private final String name;

    public TestData(TestAggregate testData) {
        this.name = testData.name();
    }

    public TestAggregate asDomain() {
        return new TestAggregate(this.name);
    }
}
