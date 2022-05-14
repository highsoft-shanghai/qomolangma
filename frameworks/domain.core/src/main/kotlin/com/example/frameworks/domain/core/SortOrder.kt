package com.example.frameworks.domain.core

interface SortOrder {
    fun property(): String
    fun direction(): SortDirection
}
