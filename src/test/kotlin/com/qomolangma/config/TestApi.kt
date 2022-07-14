package com.qomolangma.config

import com.qomolangma.frameworks.application.core.UseCase
import com.qomolangma.frameworks.domain.core.AggregateNotFoundException
import com.qomolangma.frameworks.gateways.core.OpenHostService
import com.qomolangma.frameworks.security.core.Authorities
import org.springframework.web.bind.annotation.GetMapping

@UseCase(requiredAuthorities = [Authorities.ANONYMOUS])
@OpenHostService
class TestApi{
    @GetMapping("/test-not-found")
    fun testNotFound() {
        throw AggregateNotFoundException("nothing found")
    }
}
