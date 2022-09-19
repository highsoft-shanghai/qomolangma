package com.qomolangma.iam.gateways.persistence;

import com.qomolangma.frameworks.domain.core.Identity;
import com.qomolangma.frameworks.payload.core.Payload;
import com.qomolangma.frameworks.security.core.GrantedAuthorities;
import com.qomolangma.iam.domain.User;
import com.qomolangma.iam.domain.UserIdentityOwner;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

import static com.qomolangma.frameworks.payload.core.StringFieldType.asString;

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
        Payload payload = user.contentForUsers();
        this.id = payload.get("id", asString());
        this.userAccountId = payload.get("owner.userAccount.id", asString());
        this.userAccountName = payload.get("owner.userAccount.name", asString());
        this.userId = payload.get("owner.user.id", asString());
        this.userName = payload.get("owner.user.name", asString());
        this.tenantId = payload.get("owner.tenant.id", asString());
        this.tenantName = payload.get("owner.tenant.name", asString());
        this.password = payload.get("owner.password", asString());
        this.grantedAuthorities = payload.get("authorities", asString().set());
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
