package com.example.scaffold.frameworks.test.web

import com.example.scaffold.frameworks.test.web.YesNo.Companion.of
import org.springframework.restdocs.operation.Operation
import org.springframework.restdocs.snippet.TemplatedSnippet

class ApiHeaderSnippet(authorizationRequired: Boolean) : TemplatedSnippet("api-header", null) {
    private val authorizationRequired: YesNo

    init {
        this.authorizationRequired = of(authorizationRequired)
    }

    override fun createModel(operation: Operation): Map<String, Any> {
        val model: MutableMap<String, Any> = HashMap()
        model["urlTemplate"] = getUrlTemplate(operation)
        model["httpMethod"] = operation.request.method
        model["authorizationRequired"] = authorizationRequired.toString()
        return model
    }

    private fun getUrlTemplate(operation: Operation): Any {
        val key = "org.springframework.restdocs.urlTemplate"
        return operation.attributes.getOrDefault(key, operation.request.uri.path)
    }
}
