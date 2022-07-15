package com.qomolangma.frameworks.test.persistence

import com.qomolangma.frameworks.domain.core.Exceptions.execute
import java.util.*

class Instances(private val instances: List<Any>) {
    fun autoAssignPersistence() = instances.forEach { autoAssignPersistence(it) }

    private fun autoAssignPersistence(instance: Any) {
        val fields = instance.javaClass.declaredFields
        Arrays.stream(fields).forEach {
            if (!Persistences.exist(it.type)) return@forEach
            it.isAccessible = true
            execute { it[instance] = Persistences.fetchByType(it.type) }
        }
    }
}
