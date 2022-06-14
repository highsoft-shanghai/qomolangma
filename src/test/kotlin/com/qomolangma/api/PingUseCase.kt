package com.qomolangma.api

import com.qomolangma.frameworks.application.core.UseCase
import com.qomolangma.frameworks.payload.core.Payload
import javax.annotation.Resource

@UseCase
class PingUseCase {
    @Resource
    private val ping: Ping? = null

    fun execute(payload: Payload): Payload {
        return ping!!.pong(payload)
    }
}
