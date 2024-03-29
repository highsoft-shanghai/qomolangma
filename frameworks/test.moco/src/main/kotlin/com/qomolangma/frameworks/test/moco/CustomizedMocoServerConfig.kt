package com.qomolangma.frameworks.test.moco

import com.qomolangma.frameworks.test.moco.MocoHit.hit
import com.github.dreamhead.moco.HttpServer
import com.github.dreamhead.moco.Moco.*

class CustomizedMocoServerConfig : MocoServerConfig {
    override fun configure(): HttpServer {
        val server = httpServer(hit())
        set(server)
        return server
    }

    private fun set(server: HttpServer) {
        server.request(by(uri("/ping"))).response(text("pong"))
    }

}
