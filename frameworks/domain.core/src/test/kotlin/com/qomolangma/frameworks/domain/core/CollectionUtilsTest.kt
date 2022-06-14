package com.qomolangma.frameworks.domain.core;

import com.google.common.collect.ImmutableList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CollectionUtilsTest {

    @Test
    void should_normal_input_list() {
        Assertions.assertThat(CollectionUtils.defaultList(ImmutableList.of(1))).isEqualTo(ImmutableList.of(1));
        Assertions.assertThat(CollectionUtils.defaultList(null)).isEqualTo(ImmutableList.of());
    }

    @Test
    void should_return_true() {
        Assertions.assertThat(CollectionUtils.isEmpty(null)).isEqualTo(true);
        Assertions.assertThat(CollectionUtils.isEmpty(new ArrayList<>())).isEqualTo(true);
        Assertions.assertThat(CollectionUtils.notEmpty(List.of("1"))).isEqualTo(true);
        Assertions.assertThat(CollectionUtils.isEmpty(new HashSet<>())).isTrue();
    }

    @Test
    void should_return_false() {
        Assertions.assertThat(CollectionUtils.isEmpty(List.of("1"))).isEqualTo(false);
        Assertions.assertThat(CollectionUtils.notEmpty(null)).isEqualTo(false);
        Assertions.assertThat(CollectionUtils.notEmpty(new ArrayList<>())).isEqualTo(false);
        Assertions.assertThat(CollectionUtils.isNotEmpty(new HashSet<>())).isFalse();
        Assertions.assertThat(CollectionUtils.isNotEmpty(null)).isFalse();
        Assertions.assertThat(CollectionUtils.isEmpty(Set.of("1"))).isFalse();
    }

}
