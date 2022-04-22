package com.example.frameworks.domain.core;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

class EmptyPageTest {

    @Test
    public void should_return_page_content_size_is_0_and_page_number_is_0_and_page_size() {
        EmptyPage<Object> emptyPage = new EmptyPage<>().of();
        AssertionsForClassTypes.assertThat(emptyPage.getContent().size()).isEqualTo(0);
        AssertionsForClassTypes.assertThat(emptyPage.getTotalElements()).isEqualTo(0);
        AssertionsForClassTypes.assertThat(emptyPage.getNumber()).isEqualTo(0);
        AssertionsForClassTypes.assertThat(emptyPage.getSize()).isEqualTo(0);
        AssertionsForClassTypes.assertThat(emptyPage.getNumberOfElements()).isEqualTo(0);
        AssertionsForClassTypes.assertThat(emptyPage.map(null)).isInstanceOf(EmptyPage.class);
    }
}
