package com.example.frameworks.domain.core;


public class FixedIdGenerator implements IdGenerator {

    private final String id;

    public FixedIdGenerator(String id) {
        this.id = id;
    }

    @Override
    public String next() {
        return nextReadable();
    }

    @Override
    public String nextReadable() {
        return id;
    }

}
