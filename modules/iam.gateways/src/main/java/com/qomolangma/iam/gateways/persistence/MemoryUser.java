package com.qomolangma.iam.gateways.persistence;

import com.qomolangma.frameworks.domain.core.Identity;
import com.qomolangma.frameworks.security.core.GrantedAuthorities;
import com.qomolangma.frameworks.security.core.User;
import com.qomolangma.frameworks.security.core.UserIdentityOwner;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemoryUser {
    private String id;
    private String userAccountId;
    private String userAccountName;
    private String userId;
    private String userName;
    private String tenantId;
    private String tenantName;
    private String password;
    private Set<String> grantedAuthorities;

    public MemoryUser(User user) {
        this.id = user.id();
        this.userAccountId = user.owner().userAccount().id();
        this.userAccountName = user.owner().userAccount().name();
        this.userId = user.owner().user().id();
        this.userName = user.owner().user().name();
        this.tenantId = user.owner().tenant().id();
        this.tenantName = user.owner().tenant().name();
        this.password = user.owner().password();
        this.grantedAuthorities = user.grantedAuthorities().asSet();
    }

    public String id() {
        return id;
    }

    @NotNull
    public String name() {
        return userName;
    }

    public User asDomain() {
        return User.restore(id, UserIdentityOwner.restore(new Identity(userAccountId, userAccountName), new Identity(userId, userName),
                new Identity(tenantId, tenantName), password), GrantedAuthorities.of(grantedAuthorities));
    }
}
