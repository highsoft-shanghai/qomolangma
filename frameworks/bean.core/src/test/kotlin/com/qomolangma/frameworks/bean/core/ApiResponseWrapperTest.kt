package com.qomolangma.frameworks.bean.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApiResponseWrapperTest {

    @Test
    void should_get_self_when_given_not_payload() {
        Object response = new ApiResponseWrapper().beforeBodyWrite(new NotResponsePayload(), null, null, null, null, null);
        assertThat(response).isInstanceOf(NotResponsePayload.class);
    }

    private static final class NotResponsePayload {
    }
}
