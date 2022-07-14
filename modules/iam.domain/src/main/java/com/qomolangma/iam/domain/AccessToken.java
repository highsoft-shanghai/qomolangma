package com.qomolangma.iam.domain;

import com.qomolangma.frameworks.domain.core.Id;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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

    public Instant loginTime() {
        return loginTime.loginTime();
    }

    public Boolean outOfDate() {
        return loginTime.outOfDate();
    }
}
