package com.qomolangma.frameworks.security.core;

import com.qomolangma.frameworks.domain.core.BearerToken;
import com.qomolangma.frameworks.domain.core.GlobalClock;
import com.qomolangma.frameworks.domain.core.Id;
import com.qomolangma.frameworks.payload.core.Payload;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

import java.time.Instant;

@ToString
@EqualsAndHashCode
public class AccessToken {
    private final Id id;
    private final String token;
    private final LoginTime loginTime;

    public AccessToken(String id, String token, Instant loginTime) {
        this.id = new Id(id);
        this.token = token;
        this.loginTime = new LoginTime(loginTime);
    }

    public String id() {
        return id.id();
    }

    public String token() {
        return token;
    }

    public String displayToken() {
        return BearerToken.create(token).value();
    }

    public Instant loginTime() {
        return loginTime.loginTime();
    }

    public Boolean outOfDate() {
        return loginTime.outOfDate();
    }

    @NotNull
    public static AccessToken create(@NotNull User user, TokenGenerator generator) {
        return new AccessToken(user.id(), generator.generate(user.id(), GlobalClock.now()), GlobalClock.now());
    }

    @NotNull
    public AccessToken addIn(@NotNull User.AccessTokens accessTokens) {
        accessTokens.remove(id());
        accessTokens.add(this);
        return this;
    }

    public Payload content() {
        return Payload.Companion.append("token", displayToken()).build();
    }
}
