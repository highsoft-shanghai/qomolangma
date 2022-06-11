package com.qomolangma.frameworks.domain.core

interface SortOrder {
    fun property(): String
    fun direction(): SortDirection
}
