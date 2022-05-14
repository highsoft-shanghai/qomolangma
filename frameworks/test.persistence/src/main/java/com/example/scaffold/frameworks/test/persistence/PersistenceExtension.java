package com.example.scaffold.frameworks.test.persistence;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.List;

public class PersistenceExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        List<Object> instances = context.getRequiredTestInstances().getAllInstances();
        new Instances(instances).autoAssignPersistence();
    }

}
