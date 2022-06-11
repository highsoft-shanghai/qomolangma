package com.everest.frameworks.domain.core

interface Sort : Iterable<SortOrder> {
    fun orders(): List<SortOrder>
}
