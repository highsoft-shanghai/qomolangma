package com.example.scaffold.frameworks.test.web;

import com.example.scaffold.frameworks.test.container.WithTestContainers;
import com.example.scaffold.frameworks.test.moco.MocoContainer;

@WithTestContainers(containers = {MocoContainer.class})
public abstract class IntegrationTest extends RestTest {
}
