package com.example

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class KotlinAbilityTest {
    @Test
    internal fun should_be_able_to_use_kotlin_successfully() {
        assertEquals(KotlinAbility().run(), "Hello world.");
    }
}
