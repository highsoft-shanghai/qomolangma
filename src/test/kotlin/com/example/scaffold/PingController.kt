package com.example.scaffold

import com.example.frameworks.domain.core.Payload
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource

@Tag(name = "Restful controller连通性测试接口")
@RestController
class PingController(@Resource private val pingUseCase: PingUseCase) {
    @PostMapping("/ping")
    fun ping(payload: Payload): String {
        return pingUseCase.execute(payload);
    }
}
