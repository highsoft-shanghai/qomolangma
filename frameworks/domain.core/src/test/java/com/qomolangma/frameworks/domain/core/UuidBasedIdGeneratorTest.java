package com.qomolangma.frameworks.domain.core;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class UuidBasedIdGeneratorTest {

    private IdGenerator idGenerator;

    @BeforeEach
    public void setUp() {
        idGenerator = new UuidBasedIdGenerator();
    }

    @Test
    public void should_generate_identity_correctly() {
        assertThat(32).isEqualTo(idGenerator.next().length());
    }

    @Test
    public void should_generate_non_duplicated_identities() {
        String id = idGenerator.next();
        assertThat(id).isNotEqualTo(idGenerator.next());
    }

    @Test
    public void should_generate_readable_identity_correctly() {
        assertThat(idGenerator.nextReadable().length()).isEqualTo(21);
        assertThat(idGenerator.nextReadable().chars().allMatch(Character::isDigit)).isTrue();
    }

    @Test
    public void should_generate_non_duplicated_readable_identities() {
        String id = idGenerator.nextReadable();
        assertThat(idGenerator.nextReadable()).isNotEqualTo(id);
    }

}
