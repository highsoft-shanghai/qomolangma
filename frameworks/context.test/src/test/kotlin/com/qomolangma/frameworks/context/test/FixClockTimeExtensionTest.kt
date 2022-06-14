package com.qomolangma.frameworks.context.test

import com.qomolangma.frameworks.domain.core.GlobalClock.now
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.Instant

@FixClockTime("2022-04-01T11:22:33Z")
internal class FixClockTimeExtensionTest {
    @Test
    fun should_be_able_to_fix_clock_time() {
        assertThat(now()).isEqualTo(Instant.parse("2022-04-01T11:22:33Z"))
    }
}
