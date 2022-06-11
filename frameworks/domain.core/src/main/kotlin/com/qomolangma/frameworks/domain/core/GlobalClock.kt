package com.qomolangma.frameworks.domain.core

import lombok.AccessLevel
import lombok.NoArgsConstructor
import java.time.Clock
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit

@NoArgsConstructor(access = AccessLevel.PRIVATE)
object GlobalClock {
    private var clock = Clock.system(ZoneId.of("Asia/Shanghai"))

    @JvmStatic
    fun now(): Instant {
        return clock.instant()
    }

    @JvmStatic
    fun localNow(): ZonedDateTime {
        return clock.instant().atZone(clock.zone)
    }

    @JvmStatic
    fun zone(): ZoneId {
        return clock.zone
    }

    @JvmStatic
    fun fixedAt(instant: Instant?) {
        clock = Clock.fixed(instant, zone())
    }

    @JvmStatic
    fun reset() {
        clock = Clock.system(zone())
    }

    @JvmStatic
    fun nextLocalHourlyTime(atHour: Int): ZonedDateTime {
        val now = localNow()
        return (if (now.hour < atHour) now else now.plusDays(1)).truncatedTo(ChronoUnit.DAYS).plusHours(atHour.toLong())
    }

    @JvmStatic
    fun month(): Int {
        return now().atZone(zone()).monthValue
    }
}
