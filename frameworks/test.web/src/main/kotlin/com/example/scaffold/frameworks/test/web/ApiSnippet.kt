package com.example.scaffold.frameworks.test.web;

import org.springframework.restdocs.operation.Operation;
import org.springframework.restdocs.snippet.TemplatedSnippet;

import java.util.HashMap;
import java.util.Map;

public class ApiSnippet extends TemplatedSnippet {

    protected ApiSnippet() {
        super("api", null);
    }

    @Override
    protected Map<String, Object> createModel(Operation operation) {
        Map<String, Object> model = new HashMap<>();
        model.put("identifier", operation.getName());
        return model;
    }

}
