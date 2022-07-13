package com.qomolangma.frameworks.security.core;

import com.qomolangma.frameworks.context.core.UserContext;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

@ToString
@EqualsAndHashCode
public class SimpleContext implements Context {

    private final UserContext userContext;
    private final SecurityContext securityContext;

    public SimpleContext(UserContext userContext, SecurityContext securityContext) {
        this.userContext = userContext;
        this.securityContext = securityContext;
    }

    @NotNull
    @Override
    public UserContext userContext() {
        return userContext;
    }

    @NotNull
    @Override
    public SecurityContext securityContext() {
        return securityContext;
    }

}
