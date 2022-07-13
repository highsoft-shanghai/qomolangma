package com.qomolangma.iam.domain

import com.qomolangma.frameworks.context.core.SimpleUserContext
import com.qomolangma.frameworks.domain.core.Identity
import com.qomolangma.frameworks.security.core.GrantedAuthorities
import com.qomolangma.frameworks.security.core.SimpleSecurityContext
import com.qomolangma.frameworks.test.context.WithGlobalId
import com.qomolangma.iam.domain.AccessToken.Companion.create
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@WithGlobalId("fixed-id")
internal class AccessTokenTest {
    private var owner: AccessTokenOwner? = null
    private var authorities: GrantedAuthorities? = null
    @BeforeEach
    fun setUp() {
        owner = AccessTokenOwner(NEIL_IN_QOMOLANGMA, NEIL, QOMOLANGMA)
        authorities = GrantedAuthorities.of("f1", "f2")
    }

    @Test
    fun should_be_able_to_carry_owner_info() {
        assertThat(create(owner!!, authorities!!).owner()).isEqualTo(owner)
    }

    @Test
    fun should_be_able_to_carry_granted_authorities() {
        assertThat(create(owner!!, authorities!!).grantedAuthorities()).isEqualTo(authorities)
    }

    @Test
    fun should_be_able_to_generate_id() {
        assertThat(create(owner!!, authorities!!).token()).isEqualTo("fixed-id")
    }

    @Test
    fun should_be_able_to_provide_user_context() {
        assertThat(create(owner!!, authorities!!).userContext()).isEqualTo(
            SimpleUserContext(
                NEIL_IN_QOMOLANGMA, NEIL, QOMOLANGMA
            )
        )
    }

    @Test
    fun should_be_able_to_provide_security_context() {
        assertThat(
            create(
                owner!!, authorities!!
            ).securityContext()
        ).isEqualTo(SimpleSecurityContext("fixed-id", authorities))
    }

    companion object {
        val NEIL_IN_QOMOLANGMA = Identity("neil@qomolangma", "Neil")
        val NEIL = Identity("Neil", "Neil")
        val QOMOLANGMA = Identity("qomolangma", "Qomolangma")
    }
}
