package com.qomolangma.iam.gateways.persistence

import com.qomolangma.frameworks.domain.core.Identity
import com.qomolangma.frameworks.security.core.GrantedAuthorities
import com.qomolangma.iam.domain.AccessToken
import com.qomolangma.iam.domain.AccessTokenOwner
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PersistenceAccessTokenTest {
    @Test
    internal fun should_create_access_token() {
        val identity = Identity("", "")
        val token = AccessToken.create(AccessTokenOwner(identity, identity, identity), GrantedAuthorities.of())
        val accessToken = PersistenceAccessToken(token)
        assertEquals(token.token(), accessToken.asDomain().token())
    }
}
