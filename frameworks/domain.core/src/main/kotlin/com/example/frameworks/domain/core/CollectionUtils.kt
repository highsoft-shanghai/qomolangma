@file:JvmName("CollectionUtils")

package com.example.frameworks.domain.core

fun <T> defaultList(list: List<T>?): List<T> {
    return list ?: emptyList()
}

fun <T> isEmpty(list: List<T>?): Boolean {
    return list == null || list.isEmpty()
}

fun <T> notEmpty(list: List<T>?): Boolean {
    return !isEmpty(list)
}

fun <T> isEmpty(coll: Collection<T>?): Boolean {
    return !isNotEmpty(coll)
}

fun <T> isNotEmpty(coll: Collection<T>?): Boolean {
    return coll != null && coll.isNotEmpty()
}
