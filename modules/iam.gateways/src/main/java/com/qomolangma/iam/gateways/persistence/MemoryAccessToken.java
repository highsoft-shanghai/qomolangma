package com.qomolangma.iam.gateways.persistence;

import com.qomolangma.frameworks.domain.core.Identity;
import com.qomolangma.frameworks.security.core.GrantedAuthorities;
import com.qomolangma.iam.domain.AccessToken;
import com.qomolangma.iam.domain.AccessTokenOwner;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemoryAccessToken {
    private String id;
    private String userAccountId;
    private String userAccountName;
    private String userId;
    private String userName;
    private String tenantId;
    private String tenantName;
    private Set<String> grantedAuthorities;

    public MemoryAccessToken(AccessToken accessToken) {
        this.id = accessToken.token();
        this.userAccountId = accessToken.owner().userAccount().id();
        this.userAccountName = accessToken.owner().userAccount().name();
        this.userId = accessToken.owner().user().id();
        this.userName = accessToken.owner().user().name();
        this.tenantId = accessToken.owner().tenant().id();
        this.tenantName = accessToken.owner().tenant().name();
        this.grantedAuthorities = accessToken.grantedAuthorities().asSet();
    }

    public String id() {
        return id;
    }

    public AccessToken asDomain() {
        return AccessToken.restore(
                id, new AccessTokenOwner(new Identity(userAccountId, userAccountName), new Identity(userId, userName), new Identity(tenantId, tenantName)),
                GrantedAuthorities.of(grantedAuthorities)
        );
    }

}
