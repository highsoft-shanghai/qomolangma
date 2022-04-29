package com.example.frameworks.context.test

import org.junit.jupiter.api.extension.ExtendWith

@Target(
    AnnotationTarget.ANNOTATION_CLASS,
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER,
    AnnotationTarget.ANNOTATION_CLASS
)
@Retention(AnnotationRetention.RUNTIME)
@ExtendWith(FixClockTimeExtension::class)
annotation class FixClockTime(val value: String)
