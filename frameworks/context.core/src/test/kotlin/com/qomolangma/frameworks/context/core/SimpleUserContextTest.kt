package com.qomolangma.frameworks.context.core

import com.qomolangma.frameworks.context.core.UserContext.Companion.ANONYMOUS_IDENTITY
import com.qomolangma.frameworks.domain.core.Id
import com.qomolangma.frameworks.domain.core.Identity
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SimpleUserContextTest {
    @Test
    fun should_answer_yes_when_test_for_validity() {
        assertThat(SimpleUserContext(Id(), NEIL_IN_QOMOLANGMA, NEIL, QOMOLANGMA, "Qomolangma").valid()).isTrue
    }

    @Test
    fun should_be_able_to_hold_user_account() {
        assertThat(SimpleUserContext(Id(), NEIL_IN_QOMOLANGMA, NEIL, QOMOLANGMA, "Qomolangma").userAccount()).isEqualTo(
            NEIL_IN_QOMOLANGMA
        )
    }

    @Test
    fun should_be_able_to_hold_user() {
        assertThat(SimpleUserContext(Id(), NEIL_IN_QOMOLANGMA, NEIL, QOMOLANGMA, "Qomolangma").user()).isEqualTo(NEIL)
    }

    @Test
    fun should_be_able_to_hold_tenant() {
        assertThat(SimpleUserContext(Id(), NEIL_IN_QOMOLANGMA, NEIL, QOMOLANGMA, "Qomolangma").tenant()).isEqualTo(
            QOMOLANGMA
        )
    }

    @Test
    fun should_be_able_to_hold_id() {
        assertThat(
            SimpleUserContext(
                Id("1234"),
                NEIL_IN_QOMOLANGMA,
                NEIL,
                QOMOLANGMA,
                "Qomolangma"
            ).id()
        ).isEqualTo(
            "1234"
        )
    }

    @Test
    fun should_be_able_to_hold_password() {
        assertThat(
            SimpleUserContext(
                Id(),
                NEIL_IN_QOMOLANGMA,
                NEIL,
                QOMOLANGMA,
                "Qomolangma"
            ).password()
        ).isEqualTo("Qomolangma")
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
