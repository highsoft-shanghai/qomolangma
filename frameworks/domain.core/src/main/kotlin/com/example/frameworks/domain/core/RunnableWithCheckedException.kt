package com.example.frameworks.domain.core

fun interface RunnableWithCheckedException {
    @Throws(Exception::class)
    fun run()
}
