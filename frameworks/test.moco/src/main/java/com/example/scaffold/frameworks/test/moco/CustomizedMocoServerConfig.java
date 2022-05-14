package com.example.scaffold.frameworks.test.moco;

import com.github.dreamhead.moco.HttpServer;

import static com.github.dreamhead.moco.Moco.*;

public class CustomizedMocoServerConfig implements MocoServerConfig {

    private static final Integer MOCO_PORT = 12306;

    @Override
    public HttpServer configure() {
        HttpServer server = httpServer(MOCO_PORT);
        set(server);
        return server;
    }

    private void set(HttpServer server) {
        server.request(by(uri("/ping"))).response(text("pong"));
    }

}
