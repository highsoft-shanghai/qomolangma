package com.example.frameworks.domain.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class EmptyPageTest {
    @Test
    public void should_return_page_content_size_is_0_and_page_number_is_0_and_page_size() {
        EmptyPage<Object> emptyPage = new EmptyPage<>().of();
        assertThat(emptyPage.getContent().size()).isEqualTo(0);
        assertThat(emptyPage.getTotalElements()).isEqualTo(0);
        assertThat(emptyPage.getNumber()).isEqualTo(0);
        assertThat(emptyPage.getSize()).isEqualTo(0);
        assertThat(emptyPage.getNumberOfElements()).isEqualTo(0);
        assertThat(emptyPage.map(null)).isInstanceOf(EmptyPage.class);
    }
}
