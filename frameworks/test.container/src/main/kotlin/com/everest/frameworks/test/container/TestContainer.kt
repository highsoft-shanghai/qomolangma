package com.everest.frameworks.test.container

import org.testcontainers.lifecycle.Startable

abstract class TestContainer<T : Startable> protected constructor() {
    private val container: T

    init {
        container = lazy { createContainer() }.value
    }

    fun start() {
        container.start()
        setupEnvironment()
    }

    fun container(): T {
        return container
    }

    protected abstract fun createContainer(): T
    protected abstract fun setupEnvironment()
}
