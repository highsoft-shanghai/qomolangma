package com.qomolangma.frameworks.test.persistence;

import com.qomolangma.frameworks.test.container.Containers;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.List;

public class PersistenceExtension implements BeforeEachCallback, BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) {
        new Containers<>(context, WithPersistence.class, WithPersistence::containers).startContainer();
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        List<Object> instances = context.getRequiredTestInstances().getAllInstances();
        new Instances(instances).autoAssignPersistence();
    }

}
