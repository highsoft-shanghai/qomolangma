package com.qomolangma.frameworks.payload.core

import java.util.stream.Collectors

class ConvertRules<D> @SafeVarargs constructor(vararg conventions: ConvertRule<D>) {
    private val conventions: List<ConvertRule<D>>

    init {
        this.conventions = listOf(*conventions)
    }

    private fun conventions(): List<ConvertRule<D>> {
        return conventions
    }

    fun convert(d: D): Map<String, Any> {
        return conventions().stream().collect(
            Collectors.toMap(
                { it.name() },
                { it.apply(d) },
                { _, o2 -> o2 },
                { LinkedHashMap() })
        )
    }
}
