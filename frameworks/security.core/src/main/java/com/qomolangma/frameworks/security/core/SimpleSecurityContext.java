package com.qomolangma.frameworks.security.core;

import lombok.*;

@ToString
@EqualsAndHashCode
public class SimpleSecurityContext implements SecurityContext {

    private final String id;
    private final GrantedAuthorities grantedAuthorities;

    public SimpleSecurityContext(String id, GrantedAuthorities grantedAuthorities) {
        this.id = id;
        this.grantedAuthorities = grantedAuthorities;
    }

    @Override
    public String id() {
        return id;
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
