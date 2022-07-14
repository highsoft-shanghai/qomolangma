package com.qomolangma.iam.domain

import com.qomolangma.frameworks.context.core.UserContext
import com.qomolangma.frameworks.domain.core.Id
import com.qomolangma.frameworks.payload.core.Payload
import com.qomolangma.frameworks.payload.core.Payload.Companion.append
import com.qomolangma.frameworks.security.core.Context
import com.qomolangma.frameworks.security.core.GrantedAuthorities
import com.qomolangma.frameworks.security.core.SecurityContext
import com.qomolangma.frameworks.security.core.SimpleSecurityContext
import java.util.*

class User : Context {
    private val id: Id
    private val owner: UserIdentityOwner
    private val grantedAuthorities: GrantedAuthorities

    private constructor(id: String, owner: UserIdentityOwner, grantedAuthorities: GrantedAuthorities) {
        this.id = Id(id)
        this.owner = owner
        this.grantedAuthorities = grantedAuthorities
    }

    private constructor(owner: UserIdentityOwner, grantedAuthorities: GrantedAuthorities) {
        id = Id()
        this.owner = owner
        this.grantedAuthorities = grantedAuthorities
    }

    fun owner(): UserIdentityOwner {
        return owner
    }

    fun id(): String {
        return id.id()
    }

    fun grantedAuthorities(): GrantedAuthorities {
        return grantedAuthorities
    }

    override fun userContext(): UserContext {
        return owner().asUserContext()
    }

    override fun securityContext(): SecurityContext {
        return SimpleSecurityContext(id(), grantedAuthorities())
    }

    fun content(accessTokens: AccessTokens): Payload {
        return append("accessToken", accessToken(accessTokens))
            .append("authorities", grantedAuthorities.asSet())
            .build()
    }

    private fun accessToken(accessTokens: AccessTokens): String {
        return accessTokens.getById(id()).get().token()
    }

    interface AccessTokens {
        operator fun get(token: String): Optional<AccessToken>
        fun getById(id: String): Optional<AccessToken>
        fun save(accessToken: AccessToken)
        fun remove(accessToken: AccessToken)
        fun removeAll()
    }

    companion object {
        @JvmStatic
        fun create(owner: UserIdentityOwner, authorities: GrantedAuthorities): User {
            return User(owner, authorities)
        }

        @JvmStatic
        fun restore(id: String, owner: UserIdentityOwner, authorities: GrantedAuthorities): User {
            return User(id, owner, authorities)
        }
    }
}
