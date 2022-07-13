package com.qomolangma.frameworks.security.core

import com.qomolangma.frameworks.context.core.GlobalUserContext
import com.qomolangma.frameworks.context.core.SimpleUserContext
import com.qomolangma.frameworks.context.core.UserContext
import com.qomolangma.frameworks.core.test.WithMocks
import com.qomolangma.frameworks.domain.core.Identity
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import java.util.*

@WithMocks
internal class ContextLoaderTest {
    @Mock
    private val contextProvider: ContextProvider? = null
    private var loader: ContextLoader? = null

    @BeforeEach
    fun setUp() {
        loader = ContextLoader(contextProvider!!)
    }

    @Test
    fun should_be_able_to_load_context_from_access_tokens() {
        given(contextProvider!!["token-id"]).willReturn(Optional.of(CONTEXT))
        loader!!.load("token-id")
        assertThat(GlobalUserContext.userContext()).isEqualTo(USER_CONTEXT)
        assertThat(GlobalSecurityContext.securityContext()).isEqualTo(SECURITY_CONTEXT)
    }

    @Test
    fun should_load_anonymous_context_when_no_token_id_provided() {
        loader!!.load("")
        assertThat(GlobalUserContext.userContext()).isEqualTo(UserContext.ANONYMOUS)
        assertThat(GlobalSecurityContext.securityContext()).isEqualTo(SecurityContext.ANONYMOUS)
    }

    @Test
    fun should_load_invalid_context_when_token_id_is_invalid() {
        loader!!.load("a-invalid-token-id")
        assertThat(GlobalUserContext.userContext()).isEqualTo(UserContext.INVALID)
        assertThat(GlobalSecurityContext.securityContext()).isEqualTo(SecurityContext.INVALID)
    }

    @AfterEach
    fun tearDown() {
        loader!!.clear()
    }

    companion object {
        private val USER_ACCOUNT_OF_TESTER: Identity = Identity("tester@qomolangma", "Tester")
        private val USER_OF_TESTER: Identity = Identity("tester", "Tester")
        private val TENANT_OF_QOMOLANGMA: Identity = Identity("qomolangma", "Qomolangma")
        private val USER_CONTEXT: UserContext =
            SimpleUserContext(USER_ACCOUNT_OF_TESTER, USER_OF_TESTER, TENANT_OF_QOMOLANGMA)
        private val SECURITY_CONTEXT: SecurityContext =
            SimpleSecurityContext("token-id", GrantedAuthorities.of("f1", "f2"))
        private val CONTEXT: Context = SimpleContext(USER_CONTEXT, SECURITY_CONTEXT)
    }
}
