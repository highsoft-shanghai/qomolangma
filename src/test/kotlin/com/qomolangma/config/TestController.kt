package com.qomolangma.config

import com.qomolangma.frameworks.application.core.UseCase
import com.qomolangma.frameworks.domain.core.AggregateNotFoundException
import com.qomolangma.frameworks.gateways.core.OpenHostService
import org.springframework.web.bind.annotation.GetMapping

@UseCase
@OpenHostService
class TestController {
    @GetMapping("/test-not-found")
    fun testNotFound() {
        throw AggregateNotFoundException("nothing found")
    }
}
