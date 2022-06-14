package com.qomolangma.api

import com.qomolangma.frameworks.payload.core.Payload

interface Ping {
    fun pong(payload: Payload): Payload
}
