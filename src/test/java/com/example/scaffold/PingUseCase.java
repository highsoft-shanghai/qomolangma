package com.example.scaffold;

import com.example.frameworks.application.core.UseCase;
import com.example.frameworks.domain.core.Payload;

import static com.example.frameworks.domain.core.StringFieldType.asString;

@UseCase
public class PingUseCase {
    public String execute(Payload payload) {
        return payload.get("data", asString());
    }
}
