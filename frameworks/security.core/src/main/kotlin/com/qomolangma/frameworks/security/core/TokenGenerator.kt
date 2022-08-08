package com.qomolangma.frameworks.security.core

import java.time.Instant

interface TokenGenerator {
    fun generate(id: String, loginTime: Instant): String
}
