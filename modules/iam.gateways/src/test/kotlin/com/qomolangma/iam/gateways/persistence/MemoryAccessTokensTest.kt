package com.qomolangma.iam.gateways.persistence

import com.qomolangma.iam.domain.AccessToken
import org.junit.jupiter.api.Test
import java.time.Instant
import java.util.*
import kotlin.test.assertEquals

internal class MemoryAccessTokensTest {
    @Test
    internal fun should_get_empty_when_no_access_tokens() {
        assertEquals(Optional.empty(), MemoryAccessTokens()["abc"])
    }

    @Test
    internal fun should_empty_if_out_of_date() {
        val memoryAccessTokens = MemoryAccessTokens()
        memoryAccessTokens.save(AccessToken("id", "token", Instant.EPOCH))
        assertEquals(Optional.empty(), memoryAccessTokens["token"])
    }
}
