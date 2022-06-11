package com.qomolangma.frameworks.test.moco

import com.github.dreamhead.moco.Runner
import lombok.Generated
import org.testcontainers.lifecycle.Startable

class MocoTestContainer(config: MocoServerConfig) : Startable {
    private val runner: Runner

    private val server = config.configure()

    init {
        runner = Runner.runner(server)
    }

    override fun start() {
        runner.start()
    }

    @Generated
    override fun stop() {
        runner.stop()
    }

    val url: String
        get() = "http://localhost:" + server.port()
}
