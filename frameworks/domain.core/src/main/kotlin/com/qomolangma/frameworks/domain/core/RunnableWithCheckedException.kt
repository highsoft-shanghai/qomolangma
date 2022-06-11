package com.qomolangma.frameworks.domain.core

fun interface RunnableWithCheckedException {
    @Throws(Exception::class)
    fun run()
}
