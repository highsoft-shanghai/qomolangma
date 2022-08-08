package com.qomolangma.iam.application

import com.qomolangma.frameworks.application.core.UseCase
import com.qomolangma.frameworks.payload.core.Payload
import com.qomolangma.frameworks.payload.core.StringFieldType.Companion.asString
import com.qomolangma.frameworks.security.core.Authorities
import com.qomolangma.frameworks.security.core.TokenGenerator
import com.qomolangma.frameworks.security.core.User
import com.qomolangma.frameworks.security.core.Users

@UseCase([Authorities.ANONYMOUS])
class LoginUseCase(
    private val users: Users,
    private val accessTokens: User.AccessTokens,
    private val generator: TokenGenerator
) {
    fun execute(payload: Payload): Payload {
        return users
            .getByName(payload["userName", asString()])
            .map { it.login(payload["password", asString()], accessTokens, generator) }
            .orElseThrow { IllegalArgumentException("error.login-fail") }
    }
}
