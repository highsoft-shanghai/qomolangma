package com.qomolangma.frameworks.context.core

import lombok.AccessLevel
import lombok.NoArgsConstructor

@NoArgsConstructor(access = AccessLevel.PRIVATE)
object GlobalUserContextResetter {
    @JvmStatic
    fun reset(context: UserContext) {
        GlobalUserContext.reset(context)
    }

    @JvmStatic
    fun clear() {
        GlobalUserContext.reset(UserContext.ANONYMOUS)
    }
}
