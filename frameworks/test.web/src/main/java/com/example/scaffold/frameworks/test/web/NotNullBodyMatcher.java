package com.example.scaffold.frameworks.test.web;

import static org.assertj.core.api.Assertions.assertThat;

public final class NotNullBodyMatcher implements GeneralResponseBodyMatcher {
    NotNullBodyMatcher() {
    }

    @Override
    public void match(Object target) {
        assertThat(target).isNotNull();
    }

}
