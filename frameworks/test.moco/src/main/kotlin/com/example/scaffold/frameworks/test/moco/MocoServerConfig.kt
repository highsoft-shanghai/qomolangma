package com.example.scaffold.frameworks.test.moco

import com.github.dreamhead.moco.HttpServer

interface MocoServerConfig {
    fun configure(): HttpServer
}
