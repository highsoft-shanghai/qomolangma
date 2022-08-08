package com.qomolangma.iam.gateways.persistence

import com.qomolangma.frameworks.gateways.core.Aggregates
import com.qomolangma.frameworks.security.core.AccessToken
import com.qomolangma.frameworks.security.core.User
import java.util.*

@Aggregates
class MemoryAccessTokens(
    private val tokens: MutableSet<MemoryAccessToken> = mutableSetOf(),
) : User.AccessTokens {
    override fun get(token: String): Optional<AccessToken> {
        tokens.removeIf { token == it.token() && it.asDomain().outOfDate() }
        return tokens.stream().filter { token == it.token() }.findFirst().map(MemoryAccessToken::asDomain)
    }

    override fun getById(id: String): Optional<AccessToken> {
        return tokens.stream().filter { id == it.id() }.findFirst().map(MemoryAccessToken::asDomain)
    }

    override fun add(accessToken: AccessToken) {
        tokens.add(MemoryAccessToken(accessToken))
    }

    override fun remove(id: String) {
        tokens.removeIf { id == it.id() }
    }

    override fun clear() {
        tokens.clear()
    }
}
