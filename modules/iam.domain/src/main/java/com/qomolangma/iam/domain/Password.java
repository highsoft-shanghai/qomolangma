package com.qomolangma.iam.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Base64;

import static java.nio.charset.StandardCharsets.UTF_8;

@ToString
@EqualsAndHashCode
public final class Password {
    private final String password;

    private Password(String password) {
        this.password = password;
    }

    public static Password newInstance(String password) {
        return new Password(Base64.getEncoder().encodeToString(password.getBytes(UTF_8)));
    }

    public static Password restore(String password) {
        return new Password(new String(Base64.getDecoder().decode(password)));
    }

    public String password() {
        return password;
    }
}
