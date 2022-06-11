package com.example.scaffold.frameworks.test.web;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class EmptyFilter implements Filter {

    public static final Filter INSTANCE = new EmptyFilter();

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
        return ctx.next(requestSpec, responseSpec);
    }

}
