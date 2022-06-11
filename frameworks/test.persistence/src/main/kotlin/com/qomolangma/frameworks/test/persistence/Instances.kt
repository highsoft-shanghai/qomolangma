package com.qomolangma.frameworks.test.persistence

import com.qomolangma.frameworks.domain.core.Exceptions.execute
import java.lang.reflect.Field
import java.util.*
import java.util.function.Consumer

class Instances(private val instances: List<Any>) {
    fun autoAssignPersistence() {
        instances.forEach(Consumer { instance: Any -> this.autoAssignPersistence(instance) })
    }

    private fun autoAssignPersistence(instance: Any) {
        val fields = instance.javaClass.declaredFields
        Arrays.stream(fields).forEach { field: Field ->
            if (!Persistences.exist(field.type)) return@forEach
            field.isAccessible = true
            execute { field[instance] = Persistences.fetchByType(field.type) }
        }
    }
}
