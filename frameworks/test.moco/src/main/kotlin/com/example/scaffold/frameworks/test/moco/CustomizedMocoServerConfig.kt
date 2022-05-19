package com.example.scaffold.frameworks.test.moco

import com.example.scaffold.frameworks.test.moco.MocoValidation.hit
import com.github.dreamhead.moco.HttpServer
import com.github.dreamhead.moco.Moco.*

class CustomizedMocoServerConfig : MocoServerConfig {
    override fun configure(): HttpServer {
        val server = httpServer(MOCO_PORT, hit())
        set(server)
        return server
    }

    private fun set(server: HttpServer) {
        server.request(by(uri("/ping"))).response(text("pong"))
    }

    companion object {
        private const val MOCO_PORT = 12306
    }
}
