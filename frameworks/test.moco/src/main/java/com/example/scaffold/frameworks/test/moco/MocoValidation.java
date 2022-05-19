package com.example.scaffold.frameworks.test.moco;

import com.github.dreamhead.moco.RequestHit;

import static com.github.dreamhead.moco.MocoRequestHit.requestHit;

public final class MocoValidation {

    private MocoValidation() {
    }

    private static final RequestHit IMPL = requestHit();

    public static RequestHit hit() {
        return IMPL;
    }
}
