package com.everest.frameworks.domain.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GlobalIdGeneratorTest {
    @Test
    void should_be_able_to_generate_identities_from_underlying_identity_service() {
        GlobalIdGeneratorResetter.reset(new UuidBasedIdGenerator());
        assertThat(GlobalIdGenerator.nextId()).hasSize(32);
        assertThat(GlobalIdGenerator.nextReadableId()).hasSize(21);
    }
}
