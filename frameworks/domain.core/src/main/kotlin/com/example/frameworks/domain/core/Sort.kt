package com.example.frameworks.domain.core

interface Sort : Iterable<SortOrder> {
    fun orders(): List<SortOrder>
}
