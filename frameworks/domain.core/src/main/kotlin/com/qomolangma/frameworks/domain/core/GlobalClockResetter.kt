package com.qomolangma.frameworks.domain.core

import com.qomolangma.frameworks.domain.core.GlobalClock.fixedAt
import lombok.AccessLevel
import lombok.NoArgsConstructor
import java.time.Instant

@NoArgsConstructor(access = AccessLevel.PRIVATE)
object GlobalClockResetter {
    @JvmStatic
    fun fixAt(instant: Instant?) {
        fixedAt(instant)
    }

    @JvmStatic
    fun reset() {
        GlobalClock.reset()
    }
}
