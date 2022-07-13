package com.qomolangma.iam.domain

import com.qomolangma.frameworks.domain.core.Identity
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccessTokenOwnerTest {
    private val account = Identity("qomolangma", "Qomolangma")
    private val neil = Identity("Neil", "Neil")
    private val qomolangma = Identity("qomolangma", "Qomolangma")

    @Test
    fun should_be_able_to_hold_user_account() {
        assertThat(AccessTokenOwner(account, neil, qomolangma).userAccount()).isEqualTo(account)
    }

    @Test
    fun should_be_able_to_hold_user() {
        assertThat(AccessTokenOwner(account, neil, qomolangma).user()).isEqualTo(neil)
    }

    @Test
    fun should_be_able_to_hold_tenant() {
        assertThat(AccessTokenOwner(account, neil, qomolangma).tenant()).isEqualTo(qomolangma)
    }

    @Test
    fun should_be_able_to_compare_to_others_by_contents() {
        assertThat(AccessTokenOwner(account, neil, qomolangma))
            .isEqualTo(AccessTokenOwner(account, neil, qomolangma))
    }
}
