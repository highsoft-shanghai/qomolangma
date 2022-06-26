package com.qomolangma.frameworks.persistence.spring

import com.qomolangma.frameworks.persistence.spring.SpringSort.of
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.data.domain.Sort
import org.springframework.data.domain.Sort.Order.asc
import org.springframework.data.domain.Sort.Order.desc

internal class SpringSortTest {
    @Test
    fun should_be_able_to_carry_sort_orders() {
        val sort = of(Sort.by(desc("a"), asc("b")))
        assertThat(sort.orders()).containsExactly(
            SpringSortOrder.of(desc("a")), SpringSortOrder.of(
                asc("b")
            )
        )
    }
}
