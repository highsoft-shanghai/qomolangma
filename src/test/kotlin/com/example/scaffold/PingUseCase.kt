package com.example.scaffold

import com.example.frameworks.application.core.UseCase
import com.example.frameworks.domain.core.Payload
import com.example.frameworks.domain.core.StringFieldType.Companion.asString

@UseCase
class PingUseCase {
    fun execute(payload: Payload): String {
        return payload.get("data", asString())
    }
}
