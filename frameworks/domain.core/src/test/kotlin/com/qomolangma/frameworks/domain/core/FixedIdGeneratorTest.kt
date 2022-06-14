package com.qomolangma.frameworks.domain.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FixedIdGeneratorTest {
    public static final String FIXED = "fixed";

    @Test
    void should_generate_fixed_identity() {
        Id id = new FixedId(FIXED);
        assertThat(id.next()).isEqualTo(FIXED);
        assertThat(id.nextReadable()).isEqualTo(FIXED);
    }
}
