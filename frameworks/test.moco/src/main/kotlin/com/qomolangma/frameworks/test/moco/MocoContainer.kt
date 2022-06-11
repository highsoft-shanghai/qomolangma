package com.qomolangma.frameworks.test.moco

import com.qomolangma.frameworks.test.container.TestContainer

class MocoContainer : TestContainer<MocoTestContainer>() {
    override fun createContainer(): MocoTestContainer {
        return MocoTestContainer(CustomizedMocoServerConfig())
    }

    override fun setupEnvironment() {
        System.setProperty("moco.url", container().url)
    }
}
