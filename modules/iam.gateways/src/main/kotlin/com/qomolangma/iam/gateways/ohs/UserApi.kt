package com.qomolangma.iam.gateways.ohs

import com.qomolangma.frameworks.gateways.core.OpenHostService
import com.qomolangma.frameworks.payload.core.Payload
import com.qomolangma.iam.application.RegisterUserUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.annotation.Resource

@OpenHostService
@RequestMapping("/user")
class UserApi(
    @Resource private val registerUserUseCase: RegisterUserUseCase
) {
    @PostMapping("/register")
    fun register(payload: Payload) {
        registerUserUseCase.execute(payload)
    }
}
