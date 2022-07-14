package com.qomolangma.iam.domain

import com.qomolangma.frameworks.context.core.UserContext
import com.qomolangma.frameworks.domain.core.Id
import com.qomolangma.frameworks.payload.core.Payload
import com.qomolangma.frameworks.payload.core.Payload.Companion.append
import com.qomolangma.frameworks.security.core.Context
import com.qomolangma.frameworks.security.core.GrantedAuthorities
import com.qomolangma.frameworks.security.core.SecurityContext
import com.qomolangma.frameworks.security.core.SimpleSecurityContext

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

    fun token(): String {
        return id.id()
    }

    fun grantedAuthorities(): GrantedAuthorities {
        return grantedAuthorities
    }

    override fun userContext(): UserContext {
        return owner().asUserContext()
    }

    override fun securityContext(): SecurityContext {
        return SimpleSecurityContext(token(), grantedAuthorities())
    }

    fun content(): Payload {
        return append("accessToken", token())
            .append("authorities", grantedAuthorities.asSet())
            .build()
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
