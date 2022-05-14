package com.example.scaffold.frameworks.test.persistence

import org.junit.jupiter.api.extension.ExtendWith

@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@ExtendWith(PersistenceExtension::class)
annotation class PersistenceTest
