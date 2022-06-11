package com.example.scaffold.frameworks.test.web;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/web-test")
public class WebTestController {

    @GetMapping("simple-get")
    public Object simpleGet() {
        return Map.of("name", "John");
    }

    @GetMapping("api-header/{id}")
    public Object documentApiHeader(@PathVariable String id) {
        return Map.of("id", id);
    }

    @GetMapping("api-header")
    public Object documentApiHeader() {
        return Map.of("id", "1");
    }

    @PostMapping("document-constrained-fields/{id}")
    public Object documentConstrainedFields(@PathVariable String id) {
        return Map.of("id", id);
    }

    @GetMapping("document-constrained-parameters")
    public Object documentConstrainedParameters() {
        return Map.of("content", "test");
    }

    @GetMapping("document-paged-response")
    public Object documentPagedResponse() {
        return Map.of(
                "first", true,
                "last", true,
                "numberOfTotalPages", 1,
                "numberOfTotalElements", 1,
                "numberOfElements", 1,
                "size", 10,
                "number", 0,
                "sort", List.of(Map.of("property", "name", "direction", "ASC")),
                "content", List.of(Map.of("name", "John"))
        );
    }

}
