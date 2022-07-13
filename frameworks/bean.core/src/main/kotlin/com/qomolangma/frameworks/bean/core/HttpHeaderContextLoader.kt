package com.qomolangma.frameworks.bean.core

import com.qomolangma.frameworks.security.core.ContextLoader
import javax.servlet.http.HttpServletRequest

class HttpHeaderContextLoader(authorizer: ContextLoader) : AutoCloseable {
    private val contextLoader: ContextLoader

    init {
        contextLoader = authorizer
    }

    fun load(request: HttpServletRequest) {
        contextLoader.load(BearerToken(request.getHeader("Authorization")).value())
    }

    override fun close() {
        contextLoader.clear()
    }
}
