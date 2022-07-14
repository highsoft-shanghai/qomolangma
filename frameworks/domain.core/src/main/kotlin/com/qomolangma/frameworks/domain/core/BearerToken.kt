package com.qomolangma.frameworks.domain.core

class BearerToken(private val value: String?) {
    fun value(): String? {
        return value
    }

    companion object {
        @JvmStatic
        fun create(token: String): BearerToken {
            return BearerToken(token)
        }

        @JvmStatic
        fun restore(token: String?): BearerToken {
            return BearerToken(extractToken(token))
        }

        private fun extractToken(token: String?): String? {
            if (token == null || !token.startsWith(BEARER)) return null
            return if (token.length == BEARER.length) null else token.substring(BEARER.length)
        }

        const val BEARER = "Bearer "
    }
}
