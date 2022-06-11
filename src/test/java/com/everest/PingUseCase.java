package com.everest;

import com.everest.frameworks.application.core.UseCase;
import com.everest.frameworks.valueobjects.payload.RequestPayload;
import com.everest.frameworks.valueobjects.payload.ResponsePayload;
import com.everest.frameworks.valueobjects.payload.StringFieldType;

import static com.everest.frameworks.valueobjects.payload.ResponsePayload.response;

@UseCase
public class PingUseCase {
    public ResponsePayload execute(RequestPayload payload) {
        return response().append("ping", payload.get("data", StringFieldType.asString()));
    }
}
