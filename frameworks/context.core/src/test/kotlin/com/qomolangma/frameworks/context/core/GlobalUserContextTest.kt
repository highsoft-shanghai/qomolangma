package com.qomolangma.frameworks.context.core

import com.qomolangma.frameworks.context.core.GlobalUserContext.userContext
import com.qomolangma.frameworks.domain.core.Identity
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class GlobalUserContextTest {
    @BeforeEach
    fun setUp() {
        GlobalUserContextResetter.reset(SimpleUserContext(NEIL_IN_QOMOLANGMA, NEIL, QOMOLANGMA, "Qomolangma"))
    }

    @Test
    fun should_be_able_to_hold_current_user_account() {
        assertThat(userContext().userAccount()).isEqualTo(NEIL_IN_QOMOLANGMA)
        assertThat(userContext().userAccount().id()).isEqualTo(NEIL_IN_QOMOLANGMA.id())
        assertThat(userContext().userAccount().name()).isEqualTo(NEIL_IN_QOMOLANGMA.name())
    }

    @Test
    fun should_be_able_to_hold_current_user() {
        assertThat(userContext().user()).isEqualTo(NEIL)
        assertThat(userContext().user().id()).isEqualTo(NEIL.id())
    }

    @Test
    fun should_be_able_to_hold_current_tenant() {
        assertThat(userContext().tenant()).isEqualTo(QOMOLANGMA)
        assertThat(userContext().tenant().id()).isEqualTo(QOMOLANGMA.id())
    }

    @Test
    fun should_be_able_to_hold_current_password() {
        assertThat(userContext().password()).isEqualTo("Qomolangma")
    }

    @Test
    fun should_be_able_to_clear() {
        GlobalUserContextResetter.clear()
        assertThat(userContext()).isEqualTo(UserContext.ANONYMOUS)
    }

    @AfterEach
    fun tearDown() {
        GlobalUserContextResetter.clear()
    }

    companion object {
        val NEIL_IN_QOMOLANGMA: Identity = Identity("qomolangma_Neil", "Neil")
        val NEIL: Identity = Identity("neil", "Neil")
        val QOMOLANGMA: Identity = Identity("qomolangma", "Qomolangma")
    }
}
