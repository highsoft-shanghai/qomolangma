package com.qomolangma.frameworks.application.core

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Component
@Transactional
annotation class UseCase
