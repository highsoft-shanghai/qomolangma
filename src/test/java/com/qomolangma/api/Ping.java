package com.qomolangma.api;

import com.qomolangma.frameworks.payload.core.Payload;

public interface Ping {
    Payload pong(Payload payload);
}
