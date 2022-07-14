package com.qomolangma.iam.domain

import java.util.*

interface Users {
    fun optionalAccessTokenFor(token: String): Optional<User>
    operator fun get(id: String): Optional<User>
    fun getByName(name: String): Optional<User>
    fun save(user: User)
    fun remove(user: User)
    fun clear()
}
