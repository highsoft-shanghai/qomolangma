package com.example.scaffold.frameworks.test.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping
    public Map<String, String> get() {
        return Map.of("id", "123");
    }
}
