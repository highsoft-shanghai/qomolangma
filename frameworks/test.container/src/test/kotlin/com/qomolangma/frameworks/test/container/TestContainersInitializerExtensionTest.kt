package com.qomolangma.frameworks.test.container

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

@WithTestContainers(containers = [DummyTestContainer::class])
internal class TestContainersInitializerExtensionTest {
    @Test
    fun should_be_able_to_start_all_test_containers() {
        Assertions.assertThat(DummyTestContainer.numberOfStarts).isEqualTo(1)
        Assertions.assertThat(DummyTestContainer.numberOfEnvironmentSetups).isEqualTo(1)
    }
}
