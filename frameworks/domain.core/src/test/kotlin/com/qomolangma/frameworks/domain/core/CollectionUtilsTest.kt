package com.qomolangma.frameworks.domain.core

import com.google.common.collect.ImmutableList
import com.qomolangma.frameworks.domain.core.CollectionUtils.defaultList
import com.qomolangma.frameworks.domain.core.CollectionUtils.isEmpty
import com.qomolangma.frameworks.domain.core.CollectionUtils.isNotEmpty
import com.qomolangma.frameworks.domain.core.CollectionUtils.notEmpty
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CollectionUtilsTest {
    @Test
    fun should_normal_input_list() {
        Assertions.assertThat(defaultList(ImmutableList.of(1))).isEqualTo(ImmutableList.of(1))
        Assertions.assertThat(defaultList<Any>(null)).isEqualTo(ImmutableList.of<Any>())
    }

    @Test
    fun should_return_true() {
        Assertions.assertThat(isEmpty<Any>(null)).isEqualTo(true)
        Assertions.assertThat(isEmpty(ArrayList<Any>())).isEqualTo(true)
        Assertions.assertThat(notEmpty(listOf("1"))).isEqualTo(true)
        Assertions.assertThat(isEmpty(HashSet<Any>())).isTrue
    }

    @Test
    fun should_return_false() {
        Assertions.assertThat(isEmpty(listOf("1"))).isEqualTo(false)
        Assertions.assertThat(notEmpty<Any>(null)).isEqualTo(false)
        Assertions.assertThat(notEmpty(ArrayList<Any>())).isEqualTo(false)
        Assertions.assertThat(isNotEmpty(HashSet<Any>())).isFalse
        Assertions.assertThat(isNotEmpty<Any>(null)).isFalse
        Assertions.assertThat(isEmpty(setOf("1"))).isFalse
    }
}
