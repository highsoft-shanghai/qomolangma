package com.qomolangma.iam.domain

import com.qomolangma.frameworks.context.core.UserContext
import com.qomolangma.frameworks.domain.core.Id
import com.qomolangma.frameworks.domain.core.Identity
import com.qomolangma.frameworks.payload.core.Payload
import com.qomolangma.frameworks.payload.core.Payload.Companion.append
import com.qomolangma.frameworks.payload.core.StringFieldType.Companion.asString
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
        return owner().asUserContext(id)
    }

    override fun securityContext(): SecurityContext {
        return SimpleSecurityContext(id(), grantedAuthorities())
    }

    fun contentWithAccessTokenDisplay(accessTokens: AccessTokens): Payload {
        return append("id", id())
            .append("userAccountName", owner.userAccount().name())
            .append("userName", owner.user().name())
            .append("tenantName", owner.tenant().name())
            .append("accessToken", accessToken(accessTokens).display())
            .append("authorities", grantedAuthorities.asSet())
            .build()
    }

    fun contentForUsers(): Payload {
        return append("id", id())
            .append("owner.userAccount.id", owner.userAccount().id())
            .append("owner.userAccount.name", owner.userAccount().name())
            .append("owner.user.id", owner.user().id())
            .append("owner.user.name", owner.user().name())
            .append("owner.tenant.id", owner.tenant().id())
            .append("owner.tenant.name", owner.tenant().name())
            .append("owner.password", owner.password())
            .append("authorities", grantedAuthorities.asSet())
            .build()
    }

    fun accessToken(accessTokens: AccessTokens) = accessTokens.getById(id()).get()

    interface AccessTokens {
        operator fun get(token: String): Optional<AccessToken>
        fun getById(id: String): Optional<AccessToken>
        fun add(accessToken: AccessToken)
        fun remove(id: String)
        fun clear()
    }

    fun register(confirmedPassword: String, users: Users) {
        owner.confirmPassword(confirmedPassword)
        owner.confirmUserName(users)
        users.add(this)
    }

    fun login(password: String, accessTokens: AccessTokens, generator: TokenGenerator): Payload {
        owner.checkPassword(password)
        return AccessToken.create(this, generator).addIn(accessTokens).content()
    }

    fun destroy(users: Users, accessTokens: AccessTokens) {
        users.remove(id())
        accessTokens.remove(id())
    }

    companion object {
        @JvmStatic
        fun create(owner: UserIdentityOwner, authorities: GrantedAuthorities): User {
            return User(owner, authorities)
        }

        @JvmStatic
        fun byPayload(payload: Payload): User {
            val owner = UserIdentityOwner.create(
                Identity.create(payload["userAccountName", asString()]),
                Identity.create(payload["userName", asString()]),
                Identity.create(payload["tenantName", asString()]),
                payload["password", asString()]
            )
            val grantedAuthorities = GrantedAuthorities.of(payload["grantedAuthorities", asString().array()].toSet())
            return User(owner, grantedAuthorities)
        }

        @JvmStatic
        fun restore(id: String, owner: UserIdentityOwner, authorities: GrantedAuthorities): User {
            return User(id, owner, authorities)
        }
    }
}
