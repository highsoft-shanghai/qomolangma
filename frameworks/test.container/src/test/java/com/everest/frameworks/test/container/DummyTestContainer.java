package com.everest.frameworks.test.container;

import org.jetbrains.annotations.NotNull;
import org.testcontainers.lifecycle.Startable;

public class DummyTestContainer extends TestContainer<Startable> {

    static int numberOfStarts;
    static int numberOfEnvironmentSetups;

    public DummyTestContainer() {
        super();
    }

    @Override
    protected @NotNull Startable createContainer() {
        return new Startable() {
            @Override
            public void start() {
                numberOfStarts += 1;
            }

            @Override
            public void stop() {
            }
        };
    }

    @Override
    protected void setupEnvironment() {
        numberOfEnvironmentSetups += 1;
    }

}
