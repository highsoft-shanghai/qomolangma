package com.example.frameworks.domain.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GlobalClock {
    private static Clock clock = Clock.system(ZoneId.of("Asia/Shanghai"));

    public static Instant now() {
        return clock.instant();
    }

    public static ZonedDateTime localNow() {
        return clock.instant().atZone(clock.getZone());
    }

    public static ZoneId zone() {
        return clock.getZone();
    }

    static void fixedAt(Instant instant) {
        GlobalClock.clock = Clock.fixed(instant, zone());
    }

    static void reset() {
        GlobalClock.clock = Clock.system(zone());
    }

    public static ZonedDateTime nextLocalHourlyTime(int atHour) {
        ZonedDateTime now = localNow();
        return (now.getHour() < atHour ? now : now.plusDays(1)).truncatedTo(ChronoUnit.DAYS).plusHours(atHour);
    }

    public static int month() {
        return now().atZone(zone()).getMonthValue();
    }
}
