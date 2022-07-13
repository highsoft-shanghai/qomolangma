package com.qomolangma.frameworks.security.core

import com.qomolangma.frameworks.security.core.GlobalSecurityContext.reset
import lombok.AccessLevel
import lombok.NoArgsConstructor

@NoArgsConstructor(access = AccessLevel.PRIVATE)
object GlobalSecurityContextResetter {
    @JvmStatic
    fun reset(context: SecurityContext) {
        GlobalSecurityContext.reset(context)
    }

    @JvmStatic
    fun clear() {
        reset()
    }
}
