package com.qomolangma.frameworks.test.context

import com.qomolangma.frameworks.domain.core.FixedIdGenerator
import com.qomolangma.frameworks.domain.core.GlobalIdGeneratorResetter.reset
import com.qomolangma.frameworks.domain.core.UuidBasedIdGenerator
import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.platform.commons.util.AnnotationUtils

class WithGlobalIdExtension : BeforeEachCallback, AfterEachCallback {
    override fun beforeEach(context: ExtensionContext) {
        val annotation = AnnotationUtils.findAnnotation(context.requiredTestClass, WithGlobalId::class.java)
        annotation.ifPresent { x: WithGlobalId -> reset(FixedIdGenerator(x.value)) }
    }

    override fun afterEach(context: ExtensionContext) {
        reset(UuidBasedIdGenerator())
    }
}
