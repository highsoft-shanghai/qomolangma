package com.qomolangma.frameworks.context.core

import com.qomolangma.frameworks.context.core.UserContext.Companion.ANONYMOUS_IDENTITY
import com.qomolangma.frameworks.domain.core.Identity
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SimpleUserContextTest {
    @Test
    fun should_answer_yes_when_test_for_validity() {
        assertThat(SimpleUserContext(NEIL_IN_QOMOLANGMA, NEIL, QOMOLANGMA).valid()).isTrue
    }

    @Test
    fun should_be_able_to_hold_user_account() {
        assertThat(SimpleUserContext(NEIL_IN_QOMOLANGMA, NEIL, QOMOLANGMA).userAccount()).isEqualTo(NEIL_IN_QOMOLANGMA)
    }

    @Test
    fun should_be_able_to_hold_user() {
        assertThat(SimpleUserContext(NEIL_IN_QOMOLANGMA, NEIL, QOMOLANGMA).user()).isEqualTo(NEIL)
    }

    @Test
    fun should_be_able_to_hold_tenant() {
        assertThat(SimpleUserContext(NEIL_IN_QOMOLANGMA, NEIL, QOMOLANGMA).tenant()).isEqualTo(QOMOLANGMA)
    }

    @Test
    internal fun should_get_anonymous_identity() {
        assertEquals("anonymous", ANONYMOUS_IDENTITY.id())
        assertEquals("Anonymous", ANONYMOUS_IDENTITY.name())
    }

    companion object {
        val NEIL_IN_QOMOLANGMA: Identity = Identity("qomolangma_Neil", "Neil")
        val NEIL: Identity = Identity("neil", "Neil")
        val QOMOLANGMA: Identity = Identity("qomolangma", "Qomolangma")
    }
}
