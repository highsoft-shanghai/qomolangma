package com.example.scaffold.frameworks.test.web;

public class TestResponseAssert {
    private final TestResponse response;

    public TestResponseAssert(TestResponse response) {
        this.response = response;
    }

    public TestResponseAssert is(ResponseMatcher matcher) {
        matcher.match(this.response);
        return this;
    }
}
