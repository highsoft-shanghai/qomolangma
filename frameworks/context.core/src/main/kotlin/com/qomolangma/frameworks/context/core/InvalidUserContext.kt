package com.qomolangma.frameworks.context.core

import com.qomolangma.frameworks.domain.core.BadAccessTokenException
import com.qomolangma.frameworks.domain.core.Identity

class InvalidUserContext : UserContext {
    override fun userAccount(): Identity {
        throw BadAccessTokenException()
    }

    override fun user(): Identity {
        throw BadAccessTokenException()
    }

    override fun tenant(): Identity {
        throw BadAccessTokenException()
    }

    override fun valid(): Boolean {
        return false
    }

    override fun password(): String {
        throw BadAccessTokenException()
    }
}
