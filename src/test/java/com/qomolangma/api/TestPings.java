package com.qomolangma.api;

import com.qomolangma.frameworks.gateways.core.Repository;

@Repository
public class TestPings implements Pings {
    @Override
    public String get() {
        return "ping";
    }
}
