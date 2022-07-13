package com.qomolangma.frameworks.security.core;

import lombok.*;

@ToString
@EqualsAndHashCode
public class SimpleSecurityContext implements SecurityContext {

    private final String token;
    private final GrantedAuthorities grantedAuthorities;

    public SimpleSecurityContext(String token, GrantedAuthorities grantedAuthorities) {
        this.token = token;
        this.grantedAuthorities = grantedAuthorities;
    }

    @Override
    public String token() {
        return token;
    }

    @Override
    public GrantedAuthorities grantedAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public boolean valid() {
        return true;
    }

}
