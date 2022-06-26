package com.qomolangma.frameworks.persistence.spring

import com.qomolangma.frameworks.persistence.spring.SpringPagination.Companion.of
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.domain.Sort.Order.asc
import org.springframework.data.domain.Sort.Order.desc

internal class SpringPaginationTest {
    @Test
    fun should_be_able_to_carry_page_number() {
        val pagination = of(PageRequest.of(3, 10))
        assertThat(pagination.pageNumber()).isEqualTo(3)
    }

    @Test
    fun should_be_able_to_carry_page_size() {
        val pagination = of(PageRequest.of(3, 10))
        assertThat(pagination.pageSize()).isEqualTo(10)
    }

    @Test
    fun should_be_able_to_carry_sort() {
        val pagination = of(PageRequest.of(3, 10, Sort.by(desc("a"), asc("b"))))
        assertThat(pagination.sort())
            .isEqualTo(SpringSort.of(Sort.by(desc("a"), asc("b"))))
    }
}
