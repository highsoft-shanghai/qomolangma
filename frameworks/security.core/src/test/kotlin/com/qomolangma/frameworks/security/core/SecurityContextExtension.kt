package com.qomolangma.frameworks.security.core

import com.qomolangma.frameworks.security.core.GlobalSecurityContextResetter.reset
import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.platform.commons.util.AnnotationUtils

class SecurityContextExtension : BeforeEachCallback, AfterEachCallback {
    override fun beforeEach(context: ExtensionContext) {
        val annotation = AnnotationUtils.findAnnotation(context.requiredTestClass, WithSecurityContext::class.java)
        annotation.ifPresent {
            reset(
                SimpleSecurityContext(
                    "simple", GrantedAuthorities.of(*it.grantedAuthorities)
                )
            )
        }
    }

    override fun afterEach(context: ExtensionContext) {
        GlobalSecurityContextResetter.clear()
    }
}
