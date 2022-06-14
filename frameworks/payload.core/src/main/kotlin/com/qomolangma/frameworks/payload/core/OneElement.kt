package com.qomolangma.frameworks.payload.core

class OneElement<D> constructor(vararg conventions: ConvertRule<D>) {
    private val conventions: ConvertRules<D>

    init {
        this.conventions = ConvertRules(*conventions)
    }

    fun transform(d: D): Map<String, Any> {
        return conventions.convert(d)
    }

    companion object {
        @JvmStatic
        fun <D> one(vararg conventions: ConvertRule<D>): OneElement<D> {
            return OneElement(*conventions)
        }
    }
}
