package com.qomolangma.infra

import com.qomolangma.frameworks.application.core.UseCase
import com.qomolangma.frameworks.domain.core.DomainException

@UseCase
class ExceptionRequestUseCase {
    fun execute() {
        throw DomainException("error.error-message")
    }
}
