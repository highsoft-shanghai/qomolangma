package com.qomolangma.frameworks.test.container

import org.testcontainers.lifecycle.Startable

class DummyTestContainer : TestContainer<Startable>() {
    override fun createContainer(): Startable {
        return object : Startable {
            override fun start() {
                numberOfStarts += 1
            }

            override fun stop() {}
        }
    }

    override fun setupEnvironment() {
        numberOfEnvironmentSetups += 1
    }

    companion object {
        @JvmField
        var numberOfStarts = 0

        @JvmField
        var numberOfEnvironmentSetups = 0
    }
}
