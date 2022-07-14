package com.qomolangma.iam.application

import com.qomolangma.frameworks.application.core.UseCase
import com.qomolangma.frameworks.payload.core.Payload
import com.qomolangma.frameworks.payload.core.StringFieldType.Companion.asString
import com.qomolangma.frameworks.security.core.Authorities
import com.qomolangma.iam.domain.User
import com.qomolangma.iam.domain.Users

@UseCase([Authorities.ANONYMOUS])
class LoginUseCase(
    private val users: Users,
    private val accessTokens: User.AccessTokens
) {
    fun execute(payload: Payload): Payload {
        return users
            .getByName(payload["userName", asString()])
            .map { it.login(payload["password", asString()], accessTokens) }
            .orElseThrow { IllegalArgumentException("error.login-fail") }
    }
}
