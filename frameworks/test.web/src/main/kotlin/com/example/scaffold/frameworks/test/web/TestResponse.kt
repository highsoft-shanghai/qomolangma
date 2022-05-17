package com.example.scaffold.frameworks.test.web

import com.jayway.jsonpath.JsonPath
import net.minidev.json.JSONArray
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class TestResponse(private val response: ResponseEntity<String>) {
    fun statusCode(): HttpStatus {
        return response.statusCode
    }

    fun <T> value(jsonPath: String): T {
        return JsonPath.compile(jsonPath).read(response.body)
    }

    fun values(jsonPath: String): Array<Any> {
        return JsonPath.compile(jsonPath).read<JSONArray>(response.body).toTypedArray()
    }

    fun textBody(): String? {
        return response.body
    }

    fun header(header: String): List<String>? {
        return response.headers[header]
    }

    fun `is`(matcher: ResponseMatcher): TestResponse {
        matcher.match(this)
        return this
    }
}
