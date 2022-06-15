package com.qomolangma.infra

import com.qomolangma.frameworks.gateways.core.AntiCorruptionLayer
import com.qomolangma.frameworks.payload.core.Payload
import com.qomolangma.frameworks.payload.core.StringFieldType.Companion.asString
import javax.annotation.Resource

@AntiCorruptionLayer
class TestPing : Ping {
    @Resource
    private val pings: Pings? = null
    override fun pong(payload: Payload): Payload {
        return Payload.append(pings!!.get(), payload.get("data", asString()))
            .append("message", "ok")
            .build()
    }
}
