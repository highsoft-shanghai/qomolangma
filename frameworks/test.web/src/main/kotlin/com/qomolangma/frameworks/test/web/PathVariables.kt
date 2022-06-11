package com.qomolangma.frameworks.test.web

class PathVariables(private val variables: Map<String, *>) {
    fun asMap(): Map<String, *> {
        return variables
    }

    companion object {
        @JvmStatic
        fun variables(variables: Map<String, *>): PathVariables {
            return PathVariables(variables)
        }
    }
}
