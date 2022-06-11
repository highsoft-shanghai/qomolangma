package com.qomolangma;

import com.qomolangma.frameworks.application.core.UseCase;
import com.qomolangma.frameworks.valueobjects.payload.RequestPayload;
import com.qomolangma.frameworks.valueobjects.payload.ResponsePayload;
import com.qomolangma.frameworks.valueobjects.payload.StringFieldType;

import static com.qomolangma.frameworks.valueobjects.payload.ResponsePayload.response;

@UseCase
public class PingUseCase {
    public ResponsePayload execute(RequestPayload payload) {
        return response().append("ping", payload.get("data", StringFieldType.asString()));
    }
}
