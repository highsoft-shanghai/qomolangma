@file:Suppress("UNCHECKED_CAST")

package com.qomolangma.frameworks.test.persistence

import java.util.function.Supplier

object Persistences {
    private val PERSISTENCE_MAP = mapOf<Class<*>, Supplier<Any>>(
        Pair(TestClient::class.java, testClient())
    )

    fun <T> fetchByType(clazz: Class<T>): T {
        return PERSISTENCE_MAP[clazz]!!.get() as T
    }

    fun exist(clazz: Class<*>): Boolean {
        return PERSISTENCE_MAP.containsKey(clazz)
    }

    private fun testClient(): Supplier<Any> {
        return Supplier { TestClient() }
    }
}
