package com.qomolangma.frameworks.bean.core

import com.qomolangma.frameworks.domain.core.BearerToken
import com.qomolangma.frameworks.security.core.ContextLoader
import lombok.Generated
import javax.servlet.http.HttpServletRequest

class HttpHeaderContextLoader(authorizer: ContextLoader) : AutoCloseable {
    private val contextLoader: ContextLoader

    init {
        contextLoader = authorizer
    }

    fun load(request: HttpServletRequest) {
        contextLoader.load(BearerToken.restore(request.getHeader("Authorization")).value())
    }

    @Generated
    override fun close() {
        contextLoader.clear()
    }
}
