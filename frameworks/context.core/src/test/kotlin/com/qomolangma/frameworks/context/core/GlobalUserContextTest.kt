package com.qomolangma.frameworks.context.core

import com.qomolangma.frameworks.context.core.GlobalUserContext.userContext
import com.qomolangma.frameworks.domain.core.Identity
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class GlobalUserContextTest {
    @BeforeEach
    fun setUp() {
        GlobalUserContextResetter.reset(SimpleUserContext(NEIL_IN_QOMOLANGMA, NEIL, QOMOLANGMA))
    }

    @Test
    fun should_be_able_to_hold_current_user_account() {
        Assertions.assertThat(userContext().userAccount()).isEqualTo(NEIL_IN_QOMOLANGMA)
        Assertions.assertThat(userContext().userAccount().id()).isEqualTo(NEIL_IN_QOMOLANGMA.id())
    }

    @Test
    fun should_be_able_to_hold_current_user() {
        Assertions.assertThat(userContext().user()).isEqualTo(NEIL)
        Assertions.assertThat(userContext().user().id()).isEqualTo(NEIL.id())
    }

    @Test
    fun should_be_able_to_hold_current_tenant() {
        Assertions.assertThat(userContext().tenant()).isEqualTo(QOMOLANGMA)
        Assertions.assertThat(userContext().tenant().id()).isEqualTo(QOMOLANGMA.id())
    }

    @Test
    fun should_be_able_to_clear() {
        GlobalUserContextResetter.clear()
        Assertions.assertThat(userContext()).isEqualTo(UserContext.ANONYMOUS)
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
