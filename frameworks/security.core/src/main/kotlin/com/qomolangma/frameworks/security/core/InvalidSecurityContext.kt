package com.qomolangma.frameworks.security.core

import com.qomolangma.frameworks.domain.core.BadAccessTokenException

class InvalidSecurityContext : SecurityContext {
    override fun id(): String {
        throw BadAccessTokenException()
    }

    override fun grantedAuthorities(): GrantedAuthorities {
        throw BadAccessTokenException()
    }

    override fun valid(): Boolean {
        return false
    }
}
