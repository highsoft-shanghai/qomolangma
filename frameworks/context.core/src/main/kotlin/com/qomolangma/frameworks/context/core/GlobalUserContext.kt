package com.qomolangma.frameworks.context.core

object GlobalUserContext {
    private val CONTEXT = ThreadLocal<UserContext>()

    @JvmStatic
    fun userContext(): UserContext {
        return context()
    }

    @JvmStatic
    fun reset(context: UserContext) {
        CONTEXT.set(context)
    }

    @JvmStatic
    private fun context(): UserContext {
        return CONTEXT.get()
    }
}
