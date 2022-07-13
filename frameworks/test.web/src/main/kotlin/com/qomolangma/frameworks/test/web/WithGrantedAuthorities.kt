package com.qomolangma.frameworks.test.web

import org.junit.jupiter.api.extension.ExtendWith
import java.lang.annotation.Inherited

@Target(
    AnnotationTarget.ANNOTATION_CLASS,
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@Inherited
@ExtendWith(WithGrantedAuthoritiesExtension::class)
annotation class WithGrantedAuthorities(val value: Array<String>)
