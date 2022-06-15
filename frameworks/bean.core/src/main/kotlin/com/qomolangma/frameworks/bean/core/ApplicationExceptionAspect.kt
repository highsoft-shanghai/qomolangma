package com.qomolangma.frameworks.bean.core

import com.qomolangma.frameworks.domain.core.AccessDeniedException
import com.qomolangma.frameworks.domain.core.AggregateNotFoundException
import lombok.Generated
import lombok.extern.slf4j.Slf4j
import org.aspectj.lang.annotation.AfterThrowing
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component

@Aspect
@Component
@Slf4j
class ApplicationExceptionAspect {
    @Generated
    @Pointcut("execution(public * *(..))")
    private fun inApplication() {
    }

    @Generated
    @Pointcut("within(com.qomolangma..*) && @within(com.qomolangma.frameworks.application.core.UseCase)")
    private fun trinityIntegrationOperation() {
    }

    @AfterThrowing(pointcut = "inApplication() && trinityIntegrationOperation()", throwing = "throwable")
    fun translate(throwable: Throwable) {
        if (throwable is AggregateNotFoundException) throw Application404Exception(throwable.message!!, throwable)
        if (throwable is IllegalArgumentException) throw Application400Exception(throwable.message!!, throwable)
        if (throwable is IllegalStateException) throw Application409Exception(throwable.message!!, throwable)
        if (throwable is AccessDeniedException) throw Application401Exception(throwable.message!!, throwable)
        throw ApplicationException(throwable.message, throwable)
    }
}
