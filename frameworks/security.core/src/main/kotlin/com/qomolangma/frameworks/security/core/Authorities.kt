package com.qomolangma.frameworks.security.core

interface Authorities {
    companion object {
        const val ADMIN = "admin"
        const val SYSTEM = "system"
        const val ANONYMOUS = "anonymous"
        const val AUTHENTICATED = "authenticated"
    }
}
