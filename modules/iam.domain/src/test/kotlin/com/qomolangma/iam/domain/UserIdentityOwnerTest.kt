package com.qomolangma.iam.domain

import com.qomolangma.frameworks.core.test.WithMocks
import com.qomolangma.frameworks.domain.core.Identity
import com.qomolangma.frameworks.security.core.GrantedAuthorities
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mock
import org.mockito.Mockito.`when`
import java.util.*

@WithMocks
internal class UserIdentityOwnerTest(
    @Mock private val users: Users
) {
    @BeforeEach
    internal fun setUp() {
        `when`(users.getByName("Neil")).thenReturn(
            Optional.of(
                User.create(
                    UserIdentityOwner.create(Identity.create(""), Identity.create("Neil"), Identity.create(""), ""),
                    GrantedAuthorities.of()
                )
            )
        )
    }

    @Test
    internal fun should_throw_when_user_exist() {
        val owner = UserIdentityOwner.create(Identity.create(""), Identity.create("Neil"), Identity.create(""), "")
        assertThrows<IllegalArgumentException> { owner.confirmUserName(users) }
    }

    @Test
    internal fun should_throw_when_user_password_incorrect() {
        val owner = UserIdentityOwner.create(Identity.create(""), Identity.create("Neil"), Identity.create(""), "12345")
        assertThrows<IllegalArgumentException> { owner.checkPassword("1234") }
    }
}
