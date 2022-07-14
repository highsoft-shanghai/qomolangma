package com.qomolangma.iam.domain

import java.util.*

interface Users {
    fun optionalAccessTokenFor(id: String): Optional<User>
    fun save(user: User)
    fun remove(user: User)
    fun removeAll()
}
