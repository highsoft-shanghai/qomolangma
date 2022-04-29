package com.example.frameworks.domain.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FixedIdGeneratorTest {
    public static final String FIXED = "fixed";

    @Test
    void should_generate_fixed_identity() {
        IdGenerator idGenerator = new FixedIdGenerator(FIXED);
        assertThat(idGenerator.next()).isEqualTo(FIXED);
        assertThat(idGenerator.nextReadable()).isEqualTo(FIXED);
    }
}
