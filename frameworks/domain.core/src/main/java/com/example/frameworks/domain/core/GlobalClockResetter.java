package com.example.frameworks.domain.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GlobalClockResetter {

    public static void fixAt(Instant instant) {
        GlobalClock.fixedAt(instant);
    }

    public static void reset() {
        GlobalClock.reset();
    }

}
