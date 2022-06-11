package com.everest.frameworks.test.container;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class TestContainersInitializerExtension implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) {
        new Containers<>(context, WithTestContainers.class, WithTestContainers::containers).startContainer();
    }

}
