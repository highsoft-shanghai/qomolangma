package com.qomolangma.frameworks.context.core

object GlobalUserContext {
    private val CONTEXT = ThreadLocal<UserContext>()
    fun userContext(): UserContext {
        return context()
    }

    fun reset(context: UserContext) {
        CONTEXT.set(context)
    }

    private fun context(): UserContext {
        return CONTEXT.get()
    }
}
