package com.qomolangma.infra

import com.qomolangma.frameworks.application.core.UseCase
import com.qomolangma.frameworks.domain.core.DomainException
import com.qomolangma.frameworks.security.core.Authorities

@UseCase(requiredAuthorities = [Authorities.AUTHENTICATED])
class ExceptionRequestUseCase {
    fun execute() {
        throw DomainException("error.error-message")
    }
}
