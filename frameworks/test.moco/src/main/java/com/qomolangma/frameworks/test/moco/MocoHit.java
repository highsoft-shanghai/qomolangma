package com.qomolangma.frameworks.test.moco;

import com.github.dreamhead.moco.RequestHit;

import static com.github.dreamhead.moco.MocoRequestHit.requestHit;

public final class MocoHit {

    private MocoHit() {
    }

    private static final RequestHit IMPL = requestHit();

    public static RequestHit hit() {
        return IMPL;
    }
}
