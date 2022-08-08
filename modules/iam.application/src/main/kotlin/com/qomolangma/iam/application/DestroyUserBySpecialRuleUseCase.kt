package com.qomolangma.iam.application

import com.qomolangma.frameworks.application.core.UseCase
import com.qomolangma.frameworks.security.core.Authorities
import com.qomolangma.frameworks.security.core.User
import com.qomolangma.frameworks.security.core.Users

@UseCase(requiredAuthorities = [Authorities.ADMIN, Authorities.SYSTEM])
class DestroyUserBySpecialRuleUseCase(
    private val users: Users,
    private val accessTokens: User.AccessTokens
) {
    fun execute(id: String) {
        users[id].ifPresent { it.destroy(users, accessTokens) }
    }
}
