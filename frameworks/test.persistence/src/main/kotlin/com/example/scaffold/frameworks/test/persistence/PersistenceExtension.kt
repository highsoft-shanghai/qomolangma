package com.example.scaffold.frameworks.test.persistence

import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext

class PersistenceExtension : BeforeEachCallback {
    override fun beforeEach(context: ExtensionContext) {
        val instances = context.requiredTestInstances.allInstances
        Instances(instances).autoAssignPersistence()
    }
}
