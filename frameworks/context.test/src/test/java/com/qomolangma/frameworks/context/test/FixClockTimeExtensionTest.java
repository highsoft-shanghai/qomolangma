package com.qomolangma.frameworks.context.test;

import com.qomolangma.frameworks.domain.core.GlobalClock;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

@FixClockTime("2022-04-01T11:22:33Z")
class FixClockTimeExtensionTest {
    @Test
    void should_be_able_to_fix_clock_time() {
        assertThat(GlobalClock.now()).isEqualTo(Instant.parse("2022-04-01T11:22:33Z"));
    }
}
