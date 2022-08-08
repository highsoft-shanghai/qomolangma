package com.qomolangma.frameworks.security.core

import com.qomolangma.frameworks.security.core.User
import java.util.*

interface Users {
    fun optionalAccessTokenFor(token: String): Optional<User>
    operator fun get(id: String): Optional<User>
    fun getByName(name: String): Optional<User>
    fun add(user: User)
    fun remove(id: String)
    fun clear()
}
