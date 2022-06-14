package com.qomolangma.frameworks.domain.core

import com.qomolangma.frameworks.domain.core.GlobalClock.localNow
import com.qomolangma.frameworks.domain.core.GlobalClock.month
import com.qomolangma.frameworks.domain.core.GlobalClock.nextLocalHourlyTime
import com.qomolangma.frameworks.domain.core.GlobalClock.now
import com.qomolangma.frameworks.domain.core.GlobalClock.zone
import com.qomolangma.frameworks.domain.core.GlobalClockResetter.fixAt
import com.qomolangma.frameworks.domain.core.GlobalClockResetter.reset
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit

class GlobalClockTest {
    @Test
    fun should_be_able_to_retrieve_time_from_underlying_clock() {
        fixAt(Instant.parse("2020-01-01T00:00:00Z"))
        assertThat(now()).isEqualTo(Instant.parse("2020-01-01T00:00:00Z"))
    }

    @Test
    fun should_be_able_to_retrieve_local_now_from_underlying_clock() {
        fixAt(Instant.parse("2019-12-31T16:00:00Z"))
        assertThat(localNow()).isEqualTo(ZonedDateTime.parse("2020-01-01T00:00:00+08:00[Asia/Shanghai]"))
        assertThat(zone()).isEqualTo(ZoneId.of("Asia/Shanghai"))
    }

    @Test
    fun should_be_able_to_reset_to_real_clock() {
        fixAt(Instant.parse("2019-12-08T16:00:00Z"))
        reset()
        assertThat(now()).isBetween(Instant.now().minus(3, ChronoUnit.SECONDS), Instant.now())
    }

    @Test
    fun should_be_able_to_get_next_local_hourly_time_at_midnight() {
        fixAt(Instant.parse("2019-12-08T16:00:00Z"))
        assertThat(nextLocalHourlyTime(0)).isEqualTo(Instant.parse("2019-12-09T16:00:00Z").atZone(zone()))
    }

    @Test
    fun should_be_able_to_get_next_local_hourly_time_before_the_given_hour() {
        fixAt(Instant.parse("2019-12-08T20:00:00Z"))
        assertThat(nextLocalHourlyTime(7)).isEqualTo(Instant.parse("2019-12-08T23:00:00Z").atZone(zone()))
    }

    @Test
    fun should_be_able_to_get_next_local_hourly_time_after_the_given_hour() {
        fixAt(Instant.parse("2019-12-08T20:00:00Z"))
        assertThat(nextLocalHourlyTime(2)).isEqualTo(Instant.parse("2019-12-09T18:00:00Z").atZone(zone()))
    }

    @Test
    fun should_be_able_to_get_current_month() {
        fixAt(Instant.parse("2019-12-08T20:00:00Z"))
        assertThat(month()).isEqualTo(12)
    }
}
