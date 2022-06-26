package com.qomolangma.frameworks.test.web

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/web-test")
class WebTestController {
    @GetMapping("simple-get")
    fun simpleGet(): Any {
        return mapOf(Pair("name", "John"))
    }

    @GetMapping("api-header/{id}")
    fun documentApiHeader(@PathVariable id: String): Any {
        return mapOf(Pair("id", id))
    }

    @GetMapping("api-header")
    fun documentApiHeader(): Any {
        return mapOf(Pair("id", "1"))
    }

    @PostMapping("document-constrained-fields/{id}")
    fun documentConstrainedFields(@PathVariable id: String): Any {
        return mapOf(Pair("id", id))
    }

    @GetMapping("document-constrained-parameters")
    fun documentConstrainedParameters(): Any {
        return mapOf(Pair("content", "test"))
    }

    @GetMapping("document-paged-response")
    fun documentPagedResponse(): Any {
        return mapOf(
            Pair("first", true),
            Pair("last", true),
            Pair("numberOfTotalPages", 1),
            Pair("numberOfTotalElements", 1),
            Pair("numberOfElements", 1),
            Pair("size", 10),
            Pair("number", 0),
            Pair("sort", listOf(mapOf(Pair("property", "name"), Pair("direction", "ASC")))),
            Pair("content", listOf(mapOf(Pair("name", "John"))))
        )
    }
}
