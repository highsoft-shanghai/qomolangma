package com.everest

import com.everest.frameworks.valueobjects.payload.RequestPayload
import com.everest.frameworks.valueobjects.payload.ResponsePayload
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
