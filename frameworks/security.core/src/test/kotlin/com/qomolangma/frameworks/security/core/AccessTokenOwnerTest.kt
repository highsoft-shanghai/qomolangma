package com.qomolangma.frameworks.security.core

import com.qomolangma.frameworks.domain.core.Identity
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*

internal class AccessTokenOwnerTest {
    private val account = Identity("qomolangma", "Qomolangma")
    private val neil = Identity("Neil", "Neil")
    private val qomolangma = Identity("qomolangma", "Qomolangma")

    @Test
    fun should_be_able_to_hold_user_account() {
        assertThat(UserIdentityOwner.create(account, neil, qomolangma, "Qomolangma").userAccount()).isEqualTo(account)
    }

    @Test
    fun should_be_able_to_hold_user() {
        assertThat(UserIdentityOwner.create(account, neil, qomolangma, "Qomolangma").user()).isEqualTo(neil)
    }

    @Test
    fun should_be_able_to_hold_tenant() {
        assertThat(UserIdentityOwner.create(account, neil, qomolangma, "Qomolangma").tenant()).isEqualTo(qomolangma)
    }

    @Test
    fun should_be_able_to_restore() {
        assertThat(
            UserIdentityOwner.restore(
                account,
                neil,
                qomolangma,
                Base64.getEncoder().encodeToString("Qomolangma".toByteArray())
            ).password()
        )
            .isEqualTo(Base64.getEncoder().encodeToString("Qomolangma".toByteArray()))
    }

    @Test
    fun should_be_able_to_compare_to_others_by_contents() {
        assertThat(UserIdentityOwner.create(account, neil, qomolangma, "Qomolangma"))
            .isEqualTo(UserIdentityOwner.create(account, neil, qomolangma, "Qomolangma"))
    }
}
