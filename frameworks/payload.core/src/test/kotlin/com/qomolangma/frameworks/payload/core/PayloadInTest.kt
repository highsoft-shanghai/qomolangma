package com.qomolangma.frameworks.payload.core

import com.qomolangma.frameworks.payload.core.ConvertRule.Companion.rule
import com.qomolangma.frameworks.payload.core.ListElement.Companion.list
import com.qomolangma.frameworks.payload.core.OneElement.Companion.one
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PayloadInTest {
    @Test
    fun should_transform_domain_to_map() {
        val testClass = TestClass("name", "email")
        val map = one(rule("name", TestClass::name),
            rule("email", TestClass::email),
            rule("email", TestClass::email)
        ).transform(testClass)
        assertEquals("name", map["name"])
        assertEquals("email", map["email"])
    }

    @Test
    fun should_transform_list_domain_to_list_map() {
        val testClasses = listOf(TestClass("name", "email"), TestClass("name2", "email2"))
        val list = list(rule("name", TestClass::name), rule("email", TestClass::email)).transform(testClasses)
        org.assertj.core.api.Assertions.assertThat(list).hasSize(2)
        assertEquals(mapOf(Pair("name", "name"), Pair("email", "email")), list[0])
        assertEquals(mapOf(Pair("name", "name2"), Pair("email", "email2")), list[1])
    }

    private class TestClass(private val name: String, private val email: String) {
        fun name(): String {
            return name
        }

        fun email(): String {
            return email
        }
    }
}
