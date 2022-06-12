package com.qomolangma.api;

import com.qomolangma.frameworks.gateways.core.AntiCorruptionLayer;
import com.qomolangma.frameworks.payload.core.Payload;
import com.qomolangma.frameworks.payload.core.StringFieldType;

import javax.annotation.Resource;

@AntiCorruptionLayer
public class TestPing implements Ping {
    private @Resource Pings pings;

    @Override
    public Payload pong(Payload payload) {
        return Payload.append(pings.get(), payload.get("data", StringFieldType.asString()))
                .append("message", "ok")
                .build();
    }
}
