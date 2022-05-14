package com.example.scaffold.frameworks.test.moco

import com.example.scaffold.frameworks.test.container.TestContainer

class MocoContainer : TestContainer<MocoTestContainer>() {
    override fun createContainer(): MocoTestContainer {
        return MocoTestContainer(CustomizedMocoServerConfig())
    }

    override fun setupEnvironment() {
        System.setProperty("moco.url", container().url)
    }
}
