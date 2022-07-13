package com.qomolangma.frameworks.security.core;

public interface SecurityContext {

    SecurityContext ANONYMOUS = new SimpleSecurityContext("anonymous", GrantedAuthorities.ANONYMOUS);
    SecurityContext SYSTEM = new SimpleSecurityContext("system", GrantedAuthorities.SYSTEM);
    SecurityContext INVALID = new InvalidSecurityContext();

    default void authorize(RequiredAuthorities requiredAuthorities) {
        grantedAuthorities().authorize(requiredAuthorities);
    }

    String token();

    GrantedAuthorities grantedAuthorities();

    boolean valid();

}
