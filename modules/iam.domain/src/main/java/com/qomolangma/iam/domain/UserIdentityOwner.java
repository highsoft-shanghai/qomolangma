package com.qomolangma.iam.domain;

import com.qomolangma.frameworks.context.core.SimpleUserContext;
import com.qomolangma.frameworks.context.core.UserContext;
import com.qomolangma.frameworks.domain.core.Identity;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

@ToString
@EqualsAndHashCode
public final class UserIdentityOwner {
    private final Identity userAccount;
    private final Identity user;
    private final Identity tenant;
    private final Password password;

    private UserIdentityOwner(Identity userAccount, Identity user, Identity tenant, Password password) {
        this.userAccount = userAccount;
        this.user = user;
        this.tenant = tenant;
        this.password = password;
    }

    public static UserIdentityOwner create(Identity userAccount, Identity user, Identity tenant, String password) {
        return new UserIdentityOwner(userAccount, user, tenant, Password.newInstance(password));
    }

    public static UserIdentityOwner restore(Identity userAccount, Identity user, Identity tenant, String password) {
        return new UserIdentityOwner(userAccount, user, tenant, Password.restore(password));
    }

    public UserIdentityOwner(UserContext userContext) {
        this.userAccount = userContext.userAccount();
        this.user = userContext.user();
        this.tenant = userContext.tenant();
        this.password = Password.newInstance(userContext.password());
    }

    public Identity userAccount() {
        return userAccount;
    }

    public Identity user() {
        return user;
    }

    public Identity tenant() {
        return tenant;
    }

    public UserContext asUserContext() {
        return new SimpleUserContext(userAccount(), user(), tenant(), password());
    }

    public String password() {
        return password.password();
    }

    public void confirmPassword(@NotNull String confirmedPassword) {
        this.password.confirm(confirmedPassword);
    }

    public void checkPassword(@NotNull String confirmedPassword) {
        this.password.check(confirmedPassword);
    }

    public void confirmUserName(@NotNull Users users) {
        if (users.getByName(this.user().name()).isPresent()) throw new IllegalArgumentException("error.name-exist");
    }
}
