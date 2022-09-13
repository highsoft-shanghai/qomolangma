package com.qomolangma.iam.application

import com.qomolangma.frameworks.application.core.UseCase
import com.qomolangma.frameworks.security.core.Authorities
import com.qomolangma.iam.domain.User
import com.qomolangma.iam.domain.Users

@UseCase(requiredAuthorities = [Authorities.ADMIN, Authorities.SYSTEM])
class DestroyUserBySpecialRuleUseCase(
    private val users: Users,
    private val accessTokens: User.AccessTokens
) {
    fun execute(id: String) {
        users[id].ifPresent { it.destroy(users, accessTokens) }
    }
}
