package com.example.scaffold.frameworks.test.web

import io.restassured.filter.Filter
import io.restassured.filter.FilterContext
import io.restassured.response.Response
import io.restassured.specification.FilterableRequestSpecification
import io.restassured.specification.FilterableResponseSpecification

class EmptyFilter : Filter {
    override fun filter(
        requestSpec: FilterableRequestSpecification,
        responseSpec: FilterableResponseSpecification,
        ctx: FilterContext
    ): Response {
        return ctx.next(requestSpec, responseSpec)
    }

    companion object {
        @JvmField
        val INSTANCE: Filter = EmptyFilter()
    }
}
