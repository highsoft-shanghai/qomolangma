package com.qomolangma.frameworks.test.container

import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.platform.commons.util.AnnotationUtils
import org.junit.platform.commons.util.ReflectionUtils
import java.util.concurrent.ConcurrentHashMap
import java.util.function.Function

class Containers<A : Annotation?>(
    private val context: ExtensionContext,
    private val type: Class<A>,
    private val containers: Function<A, Array<Class<*>>>
) {
    fun startContainer() {
        val annotation = AnnotationUtils.findAnnotation(context.requiredTestClass, type)
        val containerClasses = listOf(*annotation.map(containers).orElse(arrayOf()))
        val newContainerClasses = containerClasses.stream().filter { !CONTAINERS.containsKey(it) }
        newContainerClasses.parallel().forEach { this.startContainer(it) }
    }

    private fun startContainer(containerClass: Class<*>) {
        val container = ReflectionUtils.newInstance(containerClass) as TestContainer<*>
        container.start()
        CONTAINERS[containerClass] = container
    }

    companion object {
        private val CONTAINERS: MutableMap<Class<*>, TestContainer<*>> = ConcurrentHashMap()
    }
}
