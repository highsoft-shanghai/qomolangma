package com.everest.frameworks.test.persistence

import org.junit.jupiter.api.extension.ExtendWith
import kotlin.reflect.KClass


@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@ExtendWith(
    PersistenceExtension::class
)
annotation class PersistenceTest(val containers: Array<KClass<*>> = [])
