package com.everest.frameworks.context.test

import com.everest.frameworks.domain.core.GlobalClockResetter
import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import java.time.Instant

class FixClockTimeExtension : BeforeEachCallback, AfterEachCallback {
    override fun beforeEach(context: ExtensionContext) {
        val annotation = context.requiredTestClass.getDeclaredAnnotation(FixClockTime::class.java)
        GlobalClockResetter.fixAt(Instant.parse(annotation.value))
    }

    override fun afterEach(context: ExtensionContext) {
        GlobalClockResetter.reset()
    }
}
