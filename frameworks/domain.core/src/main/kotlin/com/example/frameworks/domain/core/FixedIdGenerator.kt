package com.example.frameworks.domain.core

class FixedIdGenerator(private val id: String) : IdGenerator {
    override fun next(): String {
        return nextReadable()
    }

    override fun nextReadable(): String {
        return id
    }
}
