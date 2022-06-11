package com.qomolangma.frameworks.domain.core

object CollectionUtils {
    @JvmStatic
    fun <T> defaultList(list: List<T>?): List<T> {
        return list ?: emptyList()
    }

    @JvmStatic
    fun <T> isEmpty(list: List<T>?): Boolean {
        return list == null || list.isEmpty()
    }

    @JvmStatic
    fun <T> notEmpty(list: List<T>?): Boolean {
        return !isEmpty(list)
    }

    @JvmStatic
    fun <T> isEmpty(coll: Collection<T>?): Boolean {
        return !isNotEmpty(coll)
    }

    @JvmStatic
    fun <T> isNotEmpty(coll: Collection<T>?): Boolean {
        return coll != null && coll.isNotEmpty()
    }
}
