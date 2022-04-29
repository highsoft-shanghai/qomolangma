package com.example.framework.domain.core

import com.example.frameworks.domain.core.JavaAbility
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class KotlinUseJavaAbilityTest {
    @Test
    internal fun should_be_able_to_use_java_ability_by_kotlin() {
        assertEquals(JavaAbility().run(), "Hello world.");
    }
}
