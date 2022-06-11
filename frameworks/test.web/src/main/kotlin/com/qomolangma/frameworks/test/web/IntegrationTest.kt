package com.qomolangma.frameworks.test.web

import com.qomolangma.frameworks.test.container.WithTestContainers
import com.qomolangma.frameworks.test.moco.MocoContainer
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("unittest")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WithTestContainers(containers = [MocoContainer::class])
abstract class IntegrationTest : Rest()
