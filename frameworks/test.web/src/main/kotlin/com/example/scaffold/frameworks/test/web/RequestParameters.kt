package com.example.scaffold.frameworks.test.web;

import java.util.Map;

public class RequestParameters {

    private final Map<String, ?> variables;

    public static RequestParameters parameters(Map<String, ?> variables) {
        return new RequestParameters(variables);
    }

    public RequestParameters(Map<String, ?> variables) {
        this.variables = variables;
    }

    public Map<String, ?> asMap() {
        return variables;
    }

}
