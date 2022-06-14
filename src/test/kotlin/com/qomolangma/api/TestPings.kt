package com.qomolangma.api

import com.qomolangma.frameworks.gateways.core.Aggregates

@Aggregates
class TestPings : Pings {
    override fun get(): String {
        return "ping"
    }
}
