package com.example.scaffold.frameworks.test.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping
    public Map<String, String> get() {
        Map<String, String> map = new java.util.HashMap<>();
        map.put("id", "123");
        map.put("null", null);
        return map;
    }

    @GetMapping("/bad")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void bad() {
    }

    @GetMapping("/error")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void error() {
    }

    @GetMapping("/created")
    @ResponseStatus(HttpStatus.CREATED)
    public void created() {
    }

}
