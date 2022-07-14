package com.qomolangma.iam.domain

import com.qomolangma.frameworks.security.core.Context
import com.qomolangma.frameworks.security.core.ContextProvider
import java.util.*

class AccessTokenContextProvider(private val accessTokenRepository: Users) : ContextProvider {
    override fun get(id: String): Optional<Context> {
        return accessTokenRepository.optionalAccessTokenFor(id).map { x -> x }
    }
}
