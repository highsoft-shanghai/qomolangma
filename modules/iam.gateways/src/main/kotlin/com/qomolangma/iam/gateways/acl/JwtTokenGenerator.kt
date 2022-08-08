package com.qomolangma.iam.gateways.acl

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.qomolangma.frameworks.domain.core.GlobalClock
import com.qomolangma.frameworks.gateways.core.AntiCorruptionLayer
import com.qomolangma.frameworks.security.core.TokenGenerator
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.*

@AntiCorruptionLayer
class JwtTokenGenerator : TokenGenerator {
    override fun generate(id: String, loginTime: Instant): String {
        return JWT.create()
            .withHeader(mapOf())
            .withClaim("id", id)
            .withClaim("loginTime", loginTime.toString())
            .withClaim("now", GlobalClock.now().toString())
            .withExpiresAt(Date.from(GlobalClock.now().plus(3, ChronoUnit.HOURS)))
            .sign(Algorithm.HMAC256("!Q@W#E$"))
    }
}
