package com.qomolangma.frameworks.context.core

import com.qomolangma.frameworks.domain.core.Identity

interface UserContext {
    fun userAccount(): Identity
    fun user(): Identity
    fun tenant(): Identity
    fun valid(): Boolean

    companion object {
        val ANONYMOUS_IDENTITY = Identity("anonymous", "Anonymous")
        val ANONYMOUS: UserContext = SimpleUserContext(ANONYMOUS_IDENTITY, ANONYMOUS_IDENTITY, ANONYMOUS_IDENTITY)
        val INVALID: UserContext = InvalidUserContext()
    }
}
