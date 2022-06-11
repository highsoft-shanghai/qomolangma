package com.qomolangma.frameworks.test.web

class RequestParameters(private val variables: Map<String, *>) {
    fun asMap(): Map<String, *> {
        return variables
    }

    companion object {
        @JvmStatic
        fun parameters(variables: Map<String, *>): RequestParameters {
            return RequestParameters(variables)
        }
    }
}
