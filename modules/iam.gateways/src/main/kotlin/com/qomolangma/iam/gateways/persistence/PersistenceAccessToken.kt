package com.qomolangma.iam.gateways.persistence

import com.qomolangma.frameworks.domain.core.Identity
import com.qomolangma.frameworks.security.core.GrantedAuthorities
import com.qomolangma.iam.domain.AccessToken
import com.qomolangma.iam.domain.AccessTokenOwner
import lombok.AccessLevel
import lombok.NoArgsConstructor

@NoArgsConstructor(access = AccessLevel.PROTECTED)
class PersistenceAccessToken {
    private var id: String
    private var userAccountId: String
    private var userAccountName: String
    private var userId: String
    private var userName: String
    private var tenantId: String
    private var tenantName: String
    private var grantedAuthorities: Set<String>

    constructor(
        id: String,
        userAccountId: String,
        userAccountName: String,
        userId: String,
        userName: String,
        tenantId: String,
        tenantName: String,
        grantedAuthorities: Set<String>
    ) {
        this.id = id
        this.userAccountId = userAccountId
        this.userAccountName = userAccountName
        this.userId = userId
        this.userName = userName
        this.tenantId = tenantId
        this.tenantName = tenantName
        this.grantedAuthorities = grantedAuthorities
    }

    constructor(accessToken: AccessToken) {
        id = accessToken.token()
        userAccountId = accessToken.owner().userAccount().id()
        userAccountName = accessToken.owner().userAccount().name()
        userId = accessToken.owner().user().id()
        userName = accessToken.owner().user().name()
        tenantId = accessToken.owner().tenant().id()
        tenantName = accessToken.owner().tenant().name()
        grantedAuthorities = accessToken.grantedAuthorities().asSet()
    }

    fun asDomain(): AccessToken {
        return AccessToken.restore(
            id,
            AccessTokenOwner(
                Identity(userAccountId, userAccountName),
                Identity(userId, userName),
                Identity(tenantId, tenantName)
            ),
            GrantedAuthorities.of(grantedAuthorities)
        )
    }
}
