package com.qomolangma.frameworks.domain.core;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class UuidBasedIdGeneratorTest {

    private Id id;

    @BeforeEach
    public void setUp() {
        id = new UuidBasedId();
    }

    @Test
    public void should_generate_identity_correctly() {
        assertThat(32).isEqualTo(id.next().length());
    }

    @Test
    public void should_generate_non_duplicated_identities() {
        String id = this.id.next();
        assertThat(id).isNotEqualTo(this.id.next());
    }

    @Test
    public void should_generate_readable_identity_correctly() {
        assertThat(id.nextReadable().length()).isEqualTo(21);
        assertThat(id.nextReadable().chars().allMatch(Character::isDigit)).isTrue();
    }

    @Test
    public void should_generate_non_duplicated_readable_identities() {
        String id = this.id.nextReadable();
        assertThat(this.id.nextReadable()).isNotEqualTo(id);
    }

}
