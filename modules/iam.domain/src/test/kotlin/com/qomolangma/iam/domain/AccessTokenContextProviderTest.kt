package com.qomolangma.iam.domain

import com.qomolangma.frameworks.core.test.WithMocks
import com.qomolangma.frameworks.domain.core.Identity
import com.qomolangma.frameworks.security.core.ContextProvider
import com.qomolangma.frameworks.security.core.GrantedAuthorities
import com.qomolangma.iam.domain.User.Companion.restore
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import java.util.*

@WithMocks
class AccessTokenContextProviderTest(
    @Mock private val users: Users
) {
    @BeforeEach
    fun setUp() {
        given(users.optionalAccessTokenFor("token-id")).willReturn(Optional.of(TOKEN_FROM_REPOSITORY))
    }

    @Test
    fun should_be_able_to_load_accesses_token_from_underling_repository() {
        val provider: ContextProvider = AccessTokenContextProvider(users)
        assertThat(provider["token-id"]).isEqualTo(Optional.of(TOKEN_FROM_REPOSITORY))
    }

    companion object {
        private val TOKEN_OWNER = UserIdentityOwner.create(
            Identity("tester@qomolangma", "Test"),
            Identity("tester", "Tester"),
            Identity("qomolangma", "Qomolangma"),
            "Qomolangma"
        )
        private val TOKEN_FROM_REPOSITORY = restore("token-id", TOKEN_OWNER, GrantedAuthorities.of("f1"))
    }
}
