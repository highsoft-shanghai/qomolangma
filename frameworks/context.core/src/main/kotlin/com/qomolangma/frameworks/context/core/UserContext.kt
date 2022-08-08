package com.qomolangma.frameworks.context.core

import com.qomolangma.frameworks.domain.core.Id
import com.qomolangma.frameworks.domain.core.Identity

interface UserContext {
    fun id(): String
    fun userAccount(): Identity
    fun user(): Identity
    fun tenant(): Identity
    fun valid(): Boolean
    fun password(): String

    companion object {
        private const val ANONYMOUS_WORD = "Anonymous"
        val ANONYMOUS_IDENTITY = Identity("anonymous", ANONYMOUS_WORD)
        val ANONYMOUS: UserContext =
            SimpleUserContext(
                Id(ANONYMOUS_WORD),
                ANONYMOUS_IDENTITY,
                ANONYMOUS_IDENTITY,
                ANONYMOUS_IDENTITY,
                ANONYMOUS_WORD
            )
        val INVALID: UserContext = InvalidUserContext()
    }
}
