package com.qomolangma.infra

import com.qomolangma.frameworks.payload.core.Payload

interface Ping {
    fun pong(payload: Payload): Payload
}
