package com.qomolangma.frameworks.persistence.spring

import com.qomolangma.frameworks.domain.core.SortDirection.ASC
import com.qomolangma.frameworks.domain.core.SortDirection.DESC
import com.qomolangma.frameworks.persistence.spring.SpringSortOrder.of
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.data.domain.Sort.Order.asc
import org.springframework.data.domain.Sort.Order.desc

internal class SpringSortOrderTest {
    @Test
    fun should_be_able_to_carry_sort_field_name() {
        assertThat(of(asc("a")).property()).isEqualTo("a")
    }

    @Test
    fun should_be_able_to_carry_sort_direction() {
        assertThat(of(desc("a")).direction()).isEqualTo(DESC)
        assertThat(of(asc("b")).direction()).isEqualTo(ASC)
    }
}
