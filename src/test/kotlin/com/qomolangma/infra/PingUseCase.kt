package com.qomolangma.infra

import com.qomolangma.frameworks.application.core.UseCase
import com.qomolangma.frameworks.payload.core.Payload
import com.qomolangma.frameworks.security.core.Authorities
import javax.annotation.Resource

@UseCase(requiredAuthorities = [Authorities.AUTHENTICATED])
class PingUseCase {
    @Resource
    private val ping: Ping? = null

    fun execute(payload: Payload): Payload {
        return ping!!.pong(payload)
    }
}
