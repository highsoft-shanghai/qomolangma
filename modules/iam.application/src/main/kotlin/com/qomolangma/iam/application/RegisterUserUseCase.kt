package com.qomolangma.iam.application

import com.qomolangma.frameworks.application.core.UseCase
import com.qomolangma.frameworks.payload.core.Payload
import com.qomolangma.frameworks.security.core.Authorities
import com.qomolangma.iam.domain.User
import com.qomolangma.iam.domain.Users

@UseCase([Authorities.ANONYMOUS])
class RegisterUserUseCase(
    private val users: Users
) {
    fun execute(payload: Payload) {
        User.register(payload, users)
    }
}
