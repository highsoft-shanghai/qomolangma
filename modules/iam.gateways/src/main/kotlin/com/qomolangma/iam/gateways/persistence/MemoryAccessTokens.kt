package com.qomolangma.iam.gateways.persistence

import com.qomolangma.frameworks.gateways.core.Aggregates
import com.qomolangma.iam.domain.AccessToken
import com.qomolangma.iam.domain.AccessTokens
import java.util.*

@Aggregates
class MemoryAccessTokens(
    val tokens: MutableSet<MemoryAccessToken> = mutableSetOf()
) : AccessTokens {
    override fun optionalAccessTokenFor(id: String): Optional<AccessToken> {
        return tokens.stream().filter { o -> id == o.id() }.findFirst().map(MemoryAccessToken::asDomain)
    }

    override fun save(accessToken: AccessToken) {
        tokens.add(MemoryAccessToken(accessToken))
    }

    override fun remove(accessToken: AccessToken) {
        tokens.remove(MemoryAccessToken(accessToken))
    }

    override fun removeAll() {
        tokens.clear()
    }
}
