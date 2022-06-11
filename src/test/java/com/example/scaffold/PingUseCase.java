package com.example.scaffold;

import com.example.frameworks.application.core.UseCase;
import com.example.scaffold.frameworks.valueobjects.payload.RequestPayload;
import com.example.scaffold.frameworks.valueobjects.payload.ResponsePayload;

import static com.example.scaffold.frameworks.valueobjects.payload.ResponsePayload.response;
import static com.example.scaffold.frameworks.valueobjects.payload.StringFieldType.asString;

@UseCase
public class PingUseCase {
    public ResponsePayload execute(RequestPayload payload) {
        return response().append("ping", payload.get("data", asString()));
    }
}
