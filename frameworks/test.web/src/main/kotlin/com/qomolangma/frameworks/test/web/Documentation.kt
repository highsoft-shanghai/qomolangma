package com.qomolangma.frameworks.test.web

import org.springframework.restdocs.snippet.Snippet

class Documentation(private val identifier: String, vararg snippets: Snippet) {
    private val snippets: Array<Snippet>

    init {
        this.snippets = snippets as Array<Snippet>
    }

    fun identifier(): String {
        return identifier
    }

    fun snippets(): Array<Snippet> {
        return snippets
    }

    companion object {
        fun doc(identifier: String, vararg snippets: Snippet): Documentation {
            return Documentation(identifier, *snippets)
        }
    }
}
