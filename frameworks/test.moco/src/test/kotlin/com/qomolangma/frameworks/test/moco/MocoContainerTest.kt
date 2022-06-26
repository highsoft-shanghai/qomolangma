package com.qomolangma.frameworks.test.moco

import com.github.dreamhead.moco.Moco
import com.github.dreamhead.moco.MocoRequestHit
import com.qomolangma.frameworks.test.container.WithTestContainers
import com.qomolangma.frameworks.test.moco.Connection.Companion.by
import com.qomolangma.frameworks.test.moco.MocoHit.hit
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.IOException

@WithTestContainers(containers = [MocoContainer::class])
class MocoContainerTest {
    private var connection: Connection? = null
    @BeforeEach
    @Throws(IOException::class)
    fun setUp() {
        connection = by(System.getProperty("moco.url") + "/ping")
    }

    @Test
    @Throws(IOException::class)
    fun should_be_able_to_start_one_moco_container_at_target_port() {
        connection!!.connect()
        Assertions.assertEquals(200, connection!!.responseCode())
        Assertions.assertEquals("pong", connection!!.responseBody())
        hit().verify(Moco.by(Moco.uri("/ping")), MocoRequestHit.times(1))
    }

    @AfterEach
    fun tearDown() {
        connection!!.disconnect()
    }
}
