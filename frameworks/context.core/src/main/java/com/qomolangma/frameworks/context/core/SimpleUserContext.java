package com.qomolangma.frameworks.context.core;

import com.qomolangma.frameworks.domain.core.Identity;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

@ToString
@EqualsAndHashCode
public class SimpleUserContext implements UserContext {
    private final Identity userAccount;
    private final Identity user;
    private final Identity tenant;
    private final String password;

    public SimpleUserContext(Identity userAccount, Identity user, Identity tenant, String password) {
        this.userAccount = userAccount;
        this.user = user;
        this.tenant = tenant;
        this.password = password;
    }

    @NotNull
    @Override
    public Identity userAccount() {
        return userAccount.get();
    }

    @NotNull
    @Override
    public Identity user() {
        return user.get();
    }

    @NotNull
    @Override
    public Identity tenant() {
        return tenant.get();
    }

    @Override
    public boolean valid() {
        return true;
    }

    @NotNull
    @Override
    public String password() {
        return password;
    }
}
