package com.qomolangma.iam.application

import com.qomolangma.frameworks.application.core.UseCase
import com.qomolangma.frameworks.payload.core.Payload
import com.qomolangma.frameworks.security.core.Authorities
import com.qomolangma.frameworks.security.core.GlobalSecurityContext.securityContext
import com.qomolangma.iam.domain.User
import com.qomolangma.iam.domain.Users

@UseCase(requiredAuthorities = [Authorities.AUTHENTICATED])
class GetAccessTokenContentUseCase(private val users: Users, private val accessTokens: User.AccessTokens) {
    fun execute(): Payload {
        return users[securityContext().id()].map { obj -> obj.content(accessTokens) }.get()
    }
}
