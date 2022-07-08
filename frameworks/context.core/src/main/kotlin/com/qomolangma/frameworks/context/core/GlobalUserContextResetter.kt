package com.qomolangma.frameworks.context.core

import lombok.AccessLevel
import lombok.NoArgsConstructor

@NoArgsConstructor(access = AccessLevel.PRIVATE)
object GlobalUserContextResetter {
    fun reset(context: UserContext) {
        GlobalUserContext.reset(context)
    }

    fun clear() {
        GlobalUserContext.reset(UserContext.ANONYMOUS)
    }
}
