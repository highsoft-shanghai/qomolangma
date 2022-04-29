package com.example.frameworks.domain.core;


public record FixedIdGenerator(String id) implements IdGenerator {
    @Override
    public String next() {
        return nextReadable();
    }

    @Override
    public String nextReadable() {
        return id;
    }
}
