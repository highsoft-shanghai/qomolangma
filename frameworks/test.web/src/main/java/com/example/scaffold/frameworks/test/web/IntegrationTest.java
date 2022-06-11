package com.example.scaffold.frameworks.test.web;

import com.example.scaffold.frameworks.test.container.WithTestContainers;
import com.example.scaffold.frameworks.test.moco.MocoContainer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("unittest")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WithTestContainers(containers = {MocoContainer.class})
public abstract class IntegrationTest extends Rest {
}
