package com.qomolangma.frameworks.bean.core

class BearerToken(token: String?) {
    private val value: String?

    init {
        value = extractToken(token)
    }

    private fun extractToken(token: String?): String? {
        if (token == null || !token.startsWith(BEARER)) return null
        return if (token.length == BEARER.length) null else token.substring(BEARER.length)
    }

    fun value(): String? {
        return value
    }

    companion object {
        const val BEARER = "Bearer "
    }
}
