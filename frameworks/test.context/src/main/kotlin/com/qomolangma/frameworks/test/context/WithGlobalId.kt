package com.qomolangma.frameworks.test.context

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
@ExtendWith(WithGlobalIdExtension::class)
annotation class WithGlobalId(val value: String)
