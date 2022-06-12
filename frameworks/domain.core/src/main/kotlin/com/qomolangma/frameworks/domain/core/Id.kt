package com.qomolangma.frameworks.domain.core

interface Id {
    operator fun next(): String
    fun nextReadable(): String
}
