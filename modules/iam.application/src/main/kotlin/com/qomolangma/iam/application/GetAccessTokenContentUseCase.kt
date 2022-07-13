package com.qomolangma.iam.application

import com.qomolangma.frameworks.application.core.UseCase
import com.qomolangma.frameworks.payload.core.Payload
import com.qomolangma.frameworks.security.core.Authorities
import com.qomolangma.frameworks.security.core.GlobalSecurityContext.securityContext
import com.qomolangma.iam.domain.AccessToken
import com.qomolangma.iam.domain.AccessTokens

@UseCase(requiredAuthorities = [Authorities.AUTHENTICATED])
class GetAccessTokenContentUseCase(private val accessTokenRepository: AccessTokens) {
    fun execute(): Payload {
        val accessToken = accessTokenRepository.optionalAccessTokenFor(securityContext().token())
        return accessToken.map { obj -> obj.content() }.get()
    }
}
