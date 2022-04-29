package com.example.frameworks.domain.core;

import com.example.framework.domain.core.KotlinAbility;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaUseKotlinAbilityTest {
    @Test
    void should_be_able_to_use_kotlin_ability_by_java() {
        assertEquals(new KotlinAbility().run(), "Hello world.");
    }
}
