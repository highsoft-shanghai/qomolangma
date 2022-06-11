package com.everest.frameworks.domain.core

fun interface RunnableWithCheckedException {
    @Throws(Exception::class)
    fun run()
}
