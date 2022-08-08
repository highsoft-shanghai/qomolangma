package com.qomolangma.iam.gateways.ohs

import com.qomolangma.frameworks.gateways.core.OpenHostService
import com.qomolangma.frameworks.payload.core.Payload
import com.qomolangma.iam.application.DestroyUserBySpecialRuleUseCase
import com.qomolangma.iam.application.LoginUseCase
import com.qomolangma.iam.application.RegisterUserUseCase
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.annotation.Resource

@OpenHostService
@RequestMapping("/user")
class UserApi(
    @Resource private val registerUserUseCase: RegisterUserUseCase,
    @Resource private val loginUseCase: LoginUseCase,
    @Resource private val destoryUserBySpecialRuleUseCase: DestroyUserBySpecialRuleUseCase

) {
    @PostMapping("/register")
    fun register(payload: Payload) {
        registerUserUseCase.execute(payload)
    }

    @PostMapping("/login")
    fun login(payload: Payload): Payload {
        return loginUseCase.execute(payload)
    }

    @DeleteMapping("/{id}")
    fun destroy(@PathVariable id: String) {
        destoryUserBySpecialRuleUseCase.execute(id)
    }

    @DeleteMapping("/me")
    fun destroyMe() {
    }
}
