package com.qomolangma.iam.application

import com.qomolangma.frameworks.core.test.WithMocks
import com.qomolangma.frameworks.payload.core.Payload
import com.qomolangma.frameworks.security.core.TokenGenerator
import com.qomolangma.frameworks.security.core.User
import com.qomolangma.frameworks.security.core.Users
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import java.util.*

@WithMocks
internal class LoginUseCaseTest(
    @Mock private val users: Users,
    @Mock private val accessTokens: User.AccessTokens,
    @Mock private val generator: TokenGenerator
) {
    @BeforeEach
    internal fun setUp() {
        `when`(users.getByName("Neil")).thenReturn(Optional.empty())
    }

    @Test
    internal fun should_throw_when_no_this_user() {
        assertThrows(IllegalArgumentException::class.java) {
            LoginUseCase(users, accessTokens, generator).execute(
                Payload.append("userName", "Neil").append("password", "123456").build()
            )
        }
    }
}
