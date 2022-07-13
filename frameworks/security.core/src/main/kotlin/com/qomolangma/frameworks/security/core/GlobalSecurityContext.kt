package com.qomolangma.frameworks.security.core

import lombok.AccessLevel
import lombok.NoArgsConstructor

@NoArgsConstructor(access = AccessLevel.PRIVATE)
object GlobalSecurityContext {
    private val CONTEXT = ThreadLocal<SecurityContext>()
    @JvmStatic
    fun securityContext(): SecurityContext {
        return CONTEXT.get()
    }

    @JvmStatic
    fun reset(context: SecurityContext) {
        CONTEXT.set(context)
    }

    @JvmStatic
    fun reset() {
        CONTEXT.set(SecurityContext.ANONYMOUS)
    }
}
