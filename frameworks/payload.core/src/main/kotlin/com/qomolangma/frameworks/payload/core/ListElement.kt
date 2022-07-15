package com.qomolangma.frameworks.payload.core

import java.util.stream.Collectors

class ListElement<D> constructor(vararg conventions: ConvertRule<D>) {
    private val conventions: ConvertRules<D>

    init {
        this.conventions = ConvertRules(*conventions)
    }

    fun transform(objects: List<D>): List<Map<String, Any>> {
        return objects.stream().map(conventions::convert).collect(Collectors.toList())
    }

    companion object {
        @JvmStatic
        fun <D> list(vararg conventions: ConvertRule<D>): ListElement<D> {
            return ListElement(*conventions)
        }
    }
}
