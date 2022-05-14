package com.example.scaffold;

import com.example.frameworks.application.core.UseCase;
import com.example.scaffold.frameworks.valueobjects.payload.Payload;

import static com.example.scaffold.frameworks.valueobjects.payload.StringFieldType.asString;

@UseCase
public class PingUseCase {
    public String execute(Payload payload) {
        return payload.get("data", asString());
    }
}
