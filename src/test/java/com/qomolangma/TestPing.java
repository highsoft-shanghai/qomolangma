package com.qomolangma;

import com.qomolangma.frameworks.gateways.core.AntiCorruptionLayer;
import com.qomolangma.frameworks.payload.core.RequestPayload;
import com.qomolangma.frameworks.payload.core.ResponsePayload;
import com.qomolangma.frameworks.payload.core.StringFieldType;

import static com.qomolangma.frameworks.payload.core.ResponsePayload.response;

@AntiCorruptionLayer
public class TestPing implements Ping {
    @Override
    public ResponsePayload pong(RequestPayload payload) {
        return response().append("ping", payload.get("data", StringFieldType.asString()));
    }
}
