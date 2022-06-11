package com.everest.frameworks.test.web

import com.everest.frameworks.test.container.WithTestContainers
import com.everest.frameworks.test.moco.MocoContainer
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("unittest")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WithTestContainers(containers = [MocoContainer::class])
abstract class IntegrationTest : Rest()
