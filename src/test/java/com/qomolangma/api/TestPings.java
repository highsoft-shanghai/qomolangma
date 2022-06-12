package com.qomolangma.api;

import com.qomolangma.frameworks.gateways.core.Aggregates;

@Aggregates
public class TestPings implements Pings {
    @Override
    public String get() {
        return "ping";
    }
}
