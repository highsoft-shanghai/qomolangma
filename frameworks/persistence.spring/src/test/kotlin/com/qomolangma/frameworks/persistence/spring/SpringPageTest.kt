package com.qomolangma.frameworks.persistence.spring

import com.qomolangma.frameworks.persistence.spring.SpringPage.Companion.from
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort

internal class SpringPageTest {
    @Test
    fun should_be_able_to_carry_content() {
        val page = from(PageImpl(listOf("a", "b"), Pageable.ofSize(5).next().next(), 30))
        Assertions.assertThat(page.content()).containsExactly("a", "b")
    }

    @Test
    fun should_be_able_to_carry_number_of_elements() {
        val page = from(PageImpl(listOf("a", "b"), Pageable.ofSize(5).next().next(), 30))
        Assertions.assertThat(page.numberOfElements()).isEqualTo(2)
    }

    @Test
    fun should_be_able_to_carry_page_number() {
        val page = from(PageImpl(listOf("a", "b"), Pageable.ofSize(5).next().next(), 30))
        Assertions.assertThat(page.number()).isEqualTo(2)
    }

    @Test
    fun should_be_able_to_carry_page_size() {
        val page = from(PageImpl(listOf("a", "b"), Pageable.ofSize(5).next().next(), 30))
        Assertions.assertThat(page.size()).isEqualTo(5)
    }

    @Test
    fun should_be_able_to_carry_total_number_of_elements() {
        val page = from(PageImpl(listOf("a", "b"), Pageable.ofSize(5).next().next(), 30))
        Assertions.assertThat(page.numberOfTotalElements()).isEqualTo(30)
    }

    @Test
    fun should_be_able_to_carry_total_number_of_pages() {
        val page = from(PageImpl(listOf("a", "b"), Pageable.ofSize(5).next().next(), 30))
        Assertions.assertThat(page.numberOfTotalPages()).isEqualTo(6)
    }

    @Test
    fun should_be_able_to_indicate_first_page_reached() {
        Assertions.assertThat(from(PageImpl(listOf("a", "b"), Pageable.ofSize(5), 30)).first()).isTrue
        Assertions.assertThat(from(PageImpl(listOf("a", "b"), Pageable.ofSize(5).next(), 30)).first()).isFalse
    }

    @Test
    fun should_be_able_to_indicate_last_page_reached() {
        Assertions.assertThat(from(PageImpl(listOf("a", "b"), Pageable.ofSize(2).next(), 2)).last()).isTrue
        Assertions.assertThat(from(PageImpl(listOf("a", "b"), Pageable.ofSize(2), 4)).last()).isFalse
    }

    @Test
    fun should_be_able_to_map_to_others() {
        val page = from(PageImpl(listOf("a", "b"), Pageable.ofSize(5).next().next(), 30))
        Assertions.assertThat(page.map { x: String -> x + x }.content()).containsExactly("aa", "bb")
    }

    @Test
    fun should_be_able_to_carry_sort() {
        val page = from(
            PageImpl(
                listOf("b", "a"),
                PageRequest.of(0, 2, Sort.by(Sort.Order.desc("f1"), Sort.Order.asc("f2"))),
                30
            )
        )
        Assertions.assertThat(page.sort())
            .isEqualTo(SpringSort.of(Sort.by(Sort.Order.desc("f1"), Sort.Order.asc("f2"))))
    }
}
