package com.example.scaffold.frameworks.test.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping
    public Map<String, Object> get() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", "123");
        map.put("null", null);
        map.put("list", List.of("1", "2", "3"));
        map.put("empty", "");
        map.put("num", 1);
        map.put("num2", -2);
        map.put("num3", 0);
        map.put("true", true);
        map.put("false", false);
        map.put("long", 1231231212351235133L);
        map.put("long2", -123123121235123513L);
        map.put("double", -1.0);
        Short value = -1;
        map.put("short", value);
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
    public String created() {
        return "ok";
    }

    @GetMapping("/unauthorized")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void unauthorized() {
    }

    @GetMapping("/forbidden")
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void forbidden() {
    }

}
