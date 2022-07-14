package com.qomolangma.iam.gateways.persistence

import com.qomolangma.iam.domain.AccessToken
import org.junit.jupiter.api.Test
import java.time.Instant
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

internal class MemoryAccessTokensTest {
    @Test
    internal fun should_get_empty_when_no_access_tokens() {
        assertEquals(Optional.empty(), MemoryAccessTokens()["abc"])
    }

    @Test
    internal fun should_empty_if_out_of_date() {
        val memoryAccessTokens = MemoryAccessTokens()
        memoryAccessTokens.add(AccessToken("id1", "token", Instant.EPOCH))
        memoryAccessTokens.add(AccessToken("id2", "token", Instant.now()))
        memoryAccessTokens.add(AccessToken("id3", "next-token", Instant.now()))
        assertEquals("id2", memoryAccessTokens["token"].get().id())
    }
}
