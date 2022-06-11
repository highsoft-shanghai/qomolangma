package com.qomolangma.frameworks.test.web

import org.springframework.restdocs.operation.Operation
import org.springframework.restdocs.snippet.TemplatedSnippet

class ApiSnippet : TemplatedSnippet("api", null) {
    override fun createModel(operation: Operation): Map<String, Any> {
        val model: MutableMap<String, Any> = HashMap()
        model["identifier"] = operation.name
        return model
    }
}
