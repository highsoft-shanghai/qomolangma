package com.everest.frameworks.test.moco

import com.everest.frameworks.test.container.TestContainer

class MocoContainer : TestContainer<MocoTestContainer>() {
    override fun createContainer(): MocoTestContainer {
        return MocoTestContainer(CustomizedMocoServerConfig())
    }

    override fun setupEnvironment() {
        System.setProperty("moco.url", container().url)
    }
}
