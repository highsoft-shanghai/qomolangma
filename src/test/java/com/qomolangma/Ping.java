package com.qomolangma;

import com.qomolangma.frameworks.payload.core.RequestPayload;
import com.qomolangma.frameworks.payload.core.ResponsePayload;

public interface Ping {
    ResponsePayload pong(RequestPayload payload);
}
