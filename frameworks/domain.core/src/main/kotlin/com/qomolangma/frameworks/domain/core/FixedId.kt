package com.qomolangma.frameworks.domain.core

class FixedId(private val id: String) : Id {
    override fun next(): String {
        return nextReadable()
    }

    override fun nextReadable(): String {
        return id
    }
}
