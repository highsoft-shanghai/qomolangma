package com.qomolangma.frameworks.bean.core

import com.qomolangma.frameworks.application.core.UseCase
import com.qomolangma.frameworks.security.core.Authorizer
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

@Aspect
@Component
class UseCaseAspect {
    private val authorizer: Authorizer = Authorizer()

    @Around("@within(useCase)")
    fun process(joinPoint: ProceedingJoinPoint, useCase: UseCase): Any {
        authorizer.authorize(*useCase.requiredAuthorities)
        return joinPoint.proceed()
    }

}
