package com.qomolangma.frameworks.security.core

import com.qomolangma.frameworks.context.core.GlobalUserContextResetter
import com.qomolangma.frameworks.context.core.GlobalUserContextResetter.reset
import com.qomolangma.frameworks.security.core.Context.Companion.INVALID
import org.apache.commons.lang3.StringUtils

class ContextLoader(private val contextProvider: ContextProvider) {
    fun load(tokenId: String?) {
        clear()
        if (missing(tokenId)) return
        reset(loadContext(tokenId!!))
    }

    private fun missing(tokenId: String?): Boolean {
        return StringUtils.isBlank(tokenId)
    }

    private fun loadContext(tokenId: String): Context {
        return contextProvider[tokenId].orElse(INVALID)
    }

    private fun reset(context: Context) {
        reset(context.userContext())
        GlobalSecurityContextResetter.reset(context.securityContext())
    }

    fun clear() {
        GlobalUserContextResetter.clear()
        GlobalSecurityContextResetter.clear()
    }
}
