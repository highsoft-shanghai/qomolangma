package com.example.scaffold

import com.example.scaffold.frameworks.valueobjects.payload.Payload
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource

@RestController
class PingController(@Resource private val pingUseCase: PingUseCase) {
    @PostMapping("/ping")
    fun ping(payload: Payload): Map<String, String> {
        val map = hashMapOf<String, String>();
        map["data"] = pingUseCase.execute(payload)
        return map;
    }
}
