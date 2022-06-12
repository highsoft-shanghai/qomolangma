package com.qomolangma.api;

import com.qomolangma.frameworks.application.core.UseCase;
import com.qomolangma.frameworks.payload.core.RequestPayload;
import com.qomolangma.frameworks.payload.core.ResponsePayload;

import javax.annotation.Resource;

@UseCase
public class PingUseCase {
    private @Resource Ping ping;

    public ResponsePayload execute(RequestPayload payload) {
        return ping.pong(payload);
    }
}
