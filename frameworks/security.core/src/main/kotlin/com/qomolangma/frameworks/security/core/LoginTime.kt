package com.qomolangma.frameworks.security.core

import com.qomolangma.frameworks.domain.core.GlobalClock.now
import java.time.Instant
import java.time.temporal.ChronoUnit

class LoginTime(private val loginTime: Instant) {
    fun loginTime(): Instant {
        return loginTime
    }

    fun outOfDate(): Boolean {
        return expireTime().isBefore(now())
    }

    fun expireTime(): Instant {
        return loginTime.plus(3, ChronoUnit.HOURS)
    }
}
