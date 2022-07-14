package com.qomolangma.frameworks.security.core

import com.qomolangma.frameworks.context.core.UserContext

interface Context {
    fun userContext(): UserContext
    fun securityContext(): SecurityContext

    companion object {
        val INVALID: Context = SimpleContext(UserContext.INVALID, SecurityContext.INVALID)
    }
}
