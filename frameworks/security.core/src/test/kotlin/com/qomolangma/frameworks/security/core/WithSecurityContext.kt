package com.qomolangma.frameworks.security.core

import org.junit.jupiter.api.extension.ExtendWith
import java.lang.annotation.Inherited

@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Inherited
@ExtendWith(SecurityContextExtension::class)
annotation class WithSecurityContext(val grantedAuthorities: Array<String>)
