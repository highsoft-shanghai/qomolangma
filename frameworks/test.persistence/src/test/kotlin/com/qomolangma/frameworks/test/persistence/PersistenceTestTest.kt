package com.qomolangma.frameworks.test.persistence

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

@WithPersistence
class PersistenceTestTest {
    private val testClient: TestClient? = null
    private val notTestClient: NotTestClient? = null

    @Test
    fun should_be_able_to_run_test_with_persistence_ability() {
        assertNotNull(testClient)
        assertNull(notTestClient)
    }

    private class NotTestClient
}
