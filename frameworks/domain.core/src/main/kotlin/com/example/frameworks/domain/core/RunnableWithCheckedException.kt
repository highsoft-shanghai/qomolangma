package com.example.frameworks.domain.core;

@FunctionalInterface
public interface RunnableWithCheckedException {
    void run() throws Exception;
}
