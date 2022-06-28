package com.qomolangma.frameworks.domain.core

import com.qomolangma.frameworks.domain.core.GlobalIdGenerator.nextId

data class Id @JvmOverloads constructor(private val id: String = nextId()) {
    fun id(): String {
        return id
    }
}
