package com.example.scaffold

import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.springframework.stereotype.Component
import java.util.stream.Stream

@Component
class TestContainersInitializer : BeforeAllCallback {
    override fun beforeAll(context: ExtensionContext) {
        Stream.of(Runnable { startMySQL() }).parallel().forEach { obj: Runnable -> obj.run() }
    }

    private fun startMySQL() {}
    val isRunning: Boolean
        get() = true
}
