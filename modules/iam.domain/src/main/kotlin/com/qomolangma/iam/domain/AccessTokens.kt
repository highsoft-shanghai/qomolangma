package com.qomolangma.iam.domain

import java.util.*

interface AccessTokens {
    fun optionalAccessTokenFor(id: String): Optional<AccessToken>
    fun save(accessToken: AccessToken)
    fun remove(accessToken: AccessToken)
    fun removeAll()
}
