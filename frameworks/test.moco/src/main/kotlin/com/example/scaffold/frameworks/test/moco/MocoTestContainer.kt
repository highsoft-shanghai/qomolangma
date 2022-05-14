package com.example.scaffold.frameworks.test.moco

import com.github.dreamhead.moco.Runner
import lombok.Generated
import org.testcontainers.lifecycle.Startable

class MocoTestContainer(config: MocoServerConfig) : Startable {
    private val runner: Runner

    init {
        runner = Runner.runner(config.configure())
    }

    override fun start() {
        runner.start()
    }

    @Generated
    override fun stop() {
        runner.stop()
    }

    val url: String
        get() = "http://localhost:12306"
}
