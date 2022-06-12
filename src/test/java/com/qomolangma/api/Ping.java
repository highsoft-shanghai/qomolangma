package com.qomolangma.api;

import com.qomolangma.frameworks.payload.core.RequestPayload;
import com.qomolangma.frameworks.payload.core.ResponsePayload;

public interface Ping {
    ResponsePayload pong(RequestPayload payload);
}
