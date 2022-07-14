package com.qomolangma.frameworks.bean.core

import com.qomolangma.frameworks.domain.core.BearerToken
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BearerTokenTest {
    @Test
    fun should_be_able_to_parse_bearer_token() {
        assertThat(BearerToken.restore("Bearer token-id").value()).isEqualTo("token-id")
    }

    @Test
    fun should_parse_non_bearer_token_as_invalid_token() {
        assertThat(BearerToken.restore("token-id").value()).isNull()
    }

    @Test
    fun should_parse_null_token_as_invalid_token() {
        assertThat(BearerToken.restore(null).value()).isNull()
    }

    @Test
    fun should_parse_prefix_only_token_as_invalid_token() {
        assertThat(BearerToken.restore(BearerToken.BEARER).value()).isNull()
    }
}
