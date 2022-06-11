package com.qomolangma.frameworks.domain.core

interface Pagination {
    fun pageNumber(): Int
    fun pageSize(): Int
    fun sort(): Sort
}
