package com.qomolangma.api;

import com.qomolangma.frameworks.gateways.core.AntiCorruptionLayer;
import com.qomolangma.frameworks.payload.core.Payload;
import com.qomolangma.frameworks.payload.core.ResponsePayload;
import com.qomolangma.frameworks.payload.core.StringFieldType;

import javax.annotation.Resource;

import static com.qomolangma.frameworks.payload.core.ResponsePayload.response;

@AntiCorruptionLayer
public class TestPing implements Ping {
    private @Resource Pings pings;

    @Override
    public ResponsePayload pong(Payload payload) {
        return response().append(pings.get(), payload.get("data", StringFieldType.asString()));
    }
}
