package com.qomolangma.iam.gateways.persistence

import org.junit.jupiter.api.Test
import java.util.Optional
import kotlin.test.assertEquals

internal class MemoryAccessTokensTest {
    @Test
    internal fun should_get_empty_when_no_access_tokens() {
        assertEquals(Optional.empty(), MemoryAccessTokens()["abc"])
    }
}
