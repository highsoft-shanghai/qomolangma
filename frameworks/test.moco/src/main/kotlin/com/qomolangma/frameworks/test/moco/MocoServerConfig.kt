package com.qomolangma.frameworks.test.moco

import com.github.dreamhead.moco.HttpServer

interface MocoServerConfig {
    fun configure(): HttpServer
}
