package com.qomolangma.frameworks.security.core;

import com.google.common.collect.Sets;
import com.qomolangma.frameworks.domain.core.AuthenticationException;
import lombok.EqualsAndHashCode;

import java.util.Set;
import java.util.stream.Collectors;

@EqualsAndHashCode
public final class GrantedAuthorities {
    public static final GrantedAuthorities ANONYMOUS = GrantedAuthorities.of(Authorities.ANONYMOUS);
    public static final GrantedAuthorities SYSTEM = GrantedAuthorities.of(Authorities.SYSTEM);
    private final Set<String> authorities;

    public static GrantedAuthorities of(String... authorities) {
        return new GrantedAuthorities(authorities);
    }

    public static GrantedAuthorities of(Set<String> authorities) {
        return new GrantedAuthorities(authorities);
    }

    private GrantedAuthorities(String... grantedAuthorities) {
        this.authorities = Set.of(grantedAuthorities);
    }

    private GrantedAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }

    public void authorize(RequiredAuthorities requiredAuthorities) {
        if (match(requiredAuthorities)) return;
        if (isAnonymous()) throw new AuthenticationException("error.authentication-required");
        throw new AuthorizationException("error.access-denied");
    }

    public Set<String> asSet() {
        return authorities;
    }

    public boolean isAnonymous() {
        return authorities.contains(Authorities.ANONYMOUS);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + authorities.stream().sorted().collect(Collectors.joining(", ")) + ")";
    }

    private boolean match(RequiredAuthorities requiredAuthorities) {
        if (isSpecialRole()) return true;
        if (requiredAuthorities.requireAnonymous()) return true;
        if (requiredAuthorities.requireAuthenticatedOnly() && !isAnonymous()) return true;
        return !Sets.intersection(authorities, requiredAuthorities.asSet()).isEmpty();
    }

    private boolean isSpecialRole() {
        return authorities.contains(Authorities.ADMIN) || authorities.contains(Authorities.SYSTEM);
    }

}
