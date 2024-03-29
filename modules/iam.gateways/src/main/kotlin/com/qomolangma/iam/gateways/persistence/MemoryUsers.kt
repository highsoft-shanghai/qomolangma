package com.qomolangma.iam.gateways.persistence

import com.qomolangma.frameworks.gateways.core.Aggregates
import com.qomolangma.iam.domain.AccessToken
import com.qomolangma.iam.domain.User
import com.qomolangma.iam.domain.Users
import java.util.*

@Aggregates
class MemoryUsers(
    private val users: MutableSet<MemoryUser> = mutableSetOf(),
    private val accessTokens: User.AccessTokens
) : Users {
    override fun optionalAccessTokenFor(token: String): Optional<User> {
        val id = accessTokens[token].map(AccessToken::id).orElse("")
        return this[id]
    }

    override fun get(id: String): Optional<User> {
        return users.stream().filter { id == it.id() }.findFirst().map(MemoryUser::asDomain)
    }

    override fun getByName(name: String): Optional<User> {
        return users.stream().filter { name == it.name() }.findFirst().map(MemoryUser::asDomain)
    }

    override fun add(user: User) {
        users.add(MemoryUser(user))
    }

    override fun remove(id: String) {
        users.removeIf { id == it.id() }
    }

    override fun clear() {
        users.clear()
    }
}
