package com.qomolangma;

import com.qomolangma.frameworks.application.core.UseCase;
import com.qomolangma.frameworks.payload.core.RequestPayload;
import com.qomolangma.frameworks.payload.core.ResponsePayload;
import com.qomolangma.frameworks.payload.core.StringFieldType;

import static com.qomolangma.frameworks.payload.core.ResponsePayload.response;

@UseCase
public class PingUseCase {
    public ResponsePayload execute(RequestPayload payload) {
        return response().append("ping", payload.get("data", StringFieldType.asString()));
    }
}
