package com.example.scaffold.frameworks.test.moco;

import com.example.scaffold.frameworks.test.container.TestContainer;

public class MocoContainer extends TestContainer<MocoTestContainer> {

    @Override
    protected MocoTestContainer createContainer() {
        return new MocoTestContainer(new CustomizedMocoServerConfig());
    }

    @Override
    protected void setupEnvironment() {
        System.setProperty("moco.url", container().getUrl());
    }

}
