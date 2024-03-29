package com.qomolangma.config

import com.qomolangma.config.ApplicationExceptionAspectTest.OtherException
import com.qomolangma.frameworks.application.core.UseCase
import com.qomolangma.frameworks.domain.core.AccessDeniedException
import com.qomolangma.frameworks.security.core.Authorities

@UseCase(requiredAuthorities = [Authorities.AUTHENTICATED])
class AuthenticationExceptionTest {
    fun throwIllegalArgumentException() {
        throw IllegalArgumentException("error")
    }

    fun throw409Exception() {
        throw IllegalStateException("error")
    }

    fun throwOtherException() {
        throw OtherException("error")
    }

    fun throwAccessDeniedException() {
        throw AccessDeniedException("error")
    }
}
