package com.qomolangma.frameworks.test.web

import com.qomolangma.frameworks.security.core.GrantedAuthorities
import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.platform.commons.util.AnnotationUtils
import java.util.*

class WithGrantedAuthoritiesExtension : BeforeEachCallback, AfterEachCallback {
    override fun beforeEach(context: ExtensionContext) {
        annotation(context).ifPresent { x: WithGrantedAuthorities -> GlobalTestContext.setup(GrantedAuthorities.of(*x.value)) }
    }

    override fun afterEach(context: ExtensionContext) {
        GlobalTestContext.teardown()
    }

    private fun annotation(context: ExtensionContext): Optional<WithGrantedAuthorities> {
        val result = AnnotationUtils.findAnnotation(context.requiredTestMethod, WithGrantedAuthorities::class.java)
        return if (result.isPresent) result else AnnotationUtils.findAnnotation(
            context.requiredTestClass,
            WithGrantedAuthorities::class.java
        )
    }
}
