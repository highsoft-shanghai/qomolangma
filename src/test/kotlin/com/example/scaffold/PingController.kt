package com.example.scaffold

import com.example.frameworks.domain.core.Payload
import com.example.frameworks.domain.core.StringFieldType.asString
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Restful controller连通性测试接口")
@RestController
class PingController {
    @PostMapping("/ping")
    fun ping(payload: Payload): String {
        return payload.get("data", asString())
    }
}
