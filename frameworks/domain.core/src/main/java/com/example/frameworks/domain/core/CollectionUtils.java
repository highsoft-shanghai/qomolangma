package com.example.frameworks.domain.core;

import lombok.*;

import javax.annotation.Nullable;
import java.util.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CollectionUtils {

    public static <T> List<T> defaultList(@Nullable List<T> list) {
        return list != null ? list : Collections.emptyList();
    }

    public static <T> Boolean isEmpty(List<T> list) {
        return list == null || list.isEmpty();
    }

    public static <T> Boolean notEmpty(List<T> list) {
        return !isEmpty(list);
    }

    public static <T> Boolean isEmpty(Collection<T> coll) {
        return !isNotEmpty(coll);
    }

    public static <T> Boolean isNotEmpty(Collection<T> coll) {
        return coll != null && coll.size() > 0;
    }

}
