package com.qomolangma.frameworks.gateways.core

import org.springframework.web.bind.annotation.RestController

@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@RestController
annotation class OpenHostService
