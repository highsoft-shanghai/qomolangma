package com.qomolangma.frameworks.test.web

import org.springframework.restdocs.snippet.Snippet

class Documentation(private val identifier: String, vararg snippets: Snippet) {
    private val snippets: Array<out Snippet>

    init {
        this.snippets = snippets
    }

    fun identifier(): String {
        return identifier
    }

    fun snippets(): Array<out Snippet> {
        return snippets
    }

    companion object {
        fun doc(identifier: String, vararg snippets: Snippet): Documentation {
            return Documentation(identifier, *snippets)
        }
    }
}
