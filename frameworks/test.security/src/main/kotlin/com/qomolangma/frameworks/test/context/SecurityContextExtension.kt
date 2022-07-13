package com.qomolangma.frameworks.test.context

import com.qomolangma.frameworks.security.core.GlobalSecurityContextResetter
import com.qomolangma.frameworks.security.core.GlobalSecurityContextResetter.reset
import com.qomolangma.frameworks.security.core.GrantedAuthorities
import com.qomolangma.frameworks.security.core.SimpleSecurityContext
import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.platform.commons.util.AnnotationUtils

class SecurityContextExtension : BeforeEachCallback, AfterEachCallback {
    override fun beforeEach(context: ExtensionContext) {
        val annotation = AnnotationUtils.findAnnotation(context.requiredTestClass, WithSecurityContext::class.java)
        annotation.ifPresent { x ->
            reset(SimpleSecurityContext("simple", GrantedAuthorities.of(*x.grantedAuthorities)))
        }
    }

    override fun afterEach(context: ExtensionContext) {
        GlobalSecurityContextResetter.clear()
    }
}
