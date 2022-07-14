package com.qomolangma.iam.domain

import java.time.Instant

interface TokenGenerator {
    fun generate(id: String, loginTime: Instant): String
}
