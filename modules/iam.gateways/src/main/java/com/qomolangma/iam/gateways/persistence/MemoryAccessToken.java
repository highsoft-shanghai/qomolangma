package com.qomolangma.iam.gateways.persistence;

import com.qomolangma.iam.domain.AccessToken;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemoryAccessToken {
    private String id;
    private String token;
    private Instant loginTime;

    public MemoryAccessToken(AccessToken accessToken) {
        this.id = accessToken.id();
        this.token = accessToken.token();
        this.loginTime = accessToken.loginTime();
    }

    public String token() {
        return token;
    }

    public String id() {
        return id;
    }

    public AccessToken asDomain() {
        return new AccessToken(id, token, loginTime);
    }
}
