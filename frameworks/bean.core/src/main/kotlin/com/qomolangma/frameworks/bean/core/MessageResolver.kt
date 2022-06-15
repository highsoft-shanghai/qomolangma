package com.qomolangma.frameworks.bean.core

interface MessageResolver {
    fun resolve(code: String, vararg args: Any?): String
}
