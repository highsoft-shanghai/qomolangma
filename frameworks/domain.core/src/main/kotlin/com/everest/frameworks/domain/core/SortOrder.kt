package com.everest.frameworks.domain.core

interface SortOrder {
    fun property(): String
    fun direction(): SortDirection
}
