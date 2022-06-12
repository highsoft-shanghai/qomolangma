package com.qomolangma.api;

import com.qomolangma.frameworks.payload.core.Payload;
import com.qomolangma.frameworks.payload.core.ResponsePayload;

public interface Ping {
    ResponsePayload pong(Payload payload);
}
