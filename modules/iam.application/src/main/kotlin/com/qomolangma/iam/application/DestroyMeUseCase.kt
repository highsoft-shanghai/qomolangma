package com.qomolangma.iam.application

import com.qomolangma.frameworks.application.core.UseCase
import com.qomolangma.frameworks.context.core.GlobalUserContext
import com.qomolangma.frameworks.security.core.Authorities
import com.qomolangma.frameworks.security.core.User
import com.qomolangma.frameworks.security.core.Users

@UseCase(requiredAuthorities = [Authorities.AUTHENTICATED])
class DestroyMeUseCase(
    private val users: Users,
    private val accessTokens: User.AccessTokens
) {
    fun execute() {
        val name = GlobalUserContext.userContext().user().name()
        val byName = users.getByName(name)
        byName.ifPresent { it.destroy(users, accessTokens) }
    }

}
