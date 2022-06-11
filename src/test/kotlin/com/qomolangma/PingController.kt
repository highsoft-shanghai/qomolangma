package com.qomolangma

import com.qomolangma.frameworks.payload.core.RequestPayload
import com.qomolangma.frameworks.payload.core.ResponsePayload
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource

@RestController
class PingController(@Resource private val pingUseCase: PingUseCase) {
    @PostMapping("/ping")
    fun ping(payload: RequestPayload): ResponsePayload {
        return pingUseCase.execute(payload);
    }
}
