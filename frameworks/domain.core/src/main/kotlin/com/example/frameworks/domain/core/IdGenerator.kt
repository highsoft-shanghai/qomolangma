package com.example.frameworks.domain.core

interface IdGenerator {
    operator fun next(): String
    fun nextReadable(): String
}
