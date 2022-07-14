package com.qomolangma.iam.gateways.persistence

import com.qomolangma.frameworks.gateways.core.Aggregates
import com.qomolangma.iam.domain.User
import com.qomolangma.iam.domain.Users
import java.util.*

@Aggregates
class MemoryUsers(
    val tokens: MutableSet<MemoryUser> = mutableSetOf()
) : Users {
    override fun optionalAccessTokenFor(id: String): Optional<User> {
        return tokens.stream().filter { o -> id == o.id() }.findFirst().map(MemoryUser::asDomain)
    }

    override fun save(user: User) {
        tokens.add(MemoryUser(user))
    }

    override fun remove(user: User) {
        tokens.remove(MemoryUser(user))
    }

    override fun removeAll() {
        tokens.clear()
    }
}
