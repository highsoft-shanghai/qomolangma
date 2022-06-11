package com.qomolangma.frameworks.test.container

import org.junit.jupiter.api.extension.ExtendWith
import java.lang.annotation.Inherited
import kotlin.reflect.KClass

@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Inherited
@ExtendWith(
    TestContainersInitializerExtension::class
)
annotation class WithTestContainers(val containers: Array<KClass<*>> = [])
