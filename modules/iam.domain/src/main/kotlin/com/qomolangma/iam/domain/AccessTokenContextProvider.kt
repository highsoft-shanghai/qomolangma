package com.qomolangma.iam.domain

import com.qomolangma.frameworks.security.core.Context
import com.qomolangma.frameworks.security.core.ContextProvider
import java.util.*

class AccessTokenContextProvider(private val users: Users) : ContextProvider {
    override fun get(token: String): Optional<Context> {
        return users.optionalAccessTokenFor(token).map { x -> x }
    }
}
