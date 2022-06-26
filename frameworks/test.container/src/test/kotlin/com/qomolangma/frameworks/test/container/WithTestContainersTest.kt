package com.qomolangma.frameworks.test.container

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@WithTestContainers(containers = [DummyTestContainer::class])
internal class WithTestContainersTest {
    @Test
    fun should_be_able_to_start_all_test_containers() {
        assertThat(DummyTestContainer.numberOfStarts).isEqualTo(1)
        assertThat(DummyTestContainer.numberOfEnvironmentSetups).isEqualTo(1)
    }
}
