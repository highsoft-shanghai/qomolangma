package com.qomolangma.api

import com.qomolangma.frameworks.gateways.core.OpenHostService
import com.qomolangma.frameworks.payload.core.Payload
import com.qomolangma.frameworks.payload.core.ResponsePayload
import org.springframework.web.bind.annotation.PostMapping
import javax.annotation.Resource

@OpenHostService
class PingController(@Resource private val pingUseCase: PingUseCase) {
    @PostMapping("/ping")
    fun ping(payload: Payload): ResponsePayload {
        return pingUseCase.execute(payload);
    }
}
