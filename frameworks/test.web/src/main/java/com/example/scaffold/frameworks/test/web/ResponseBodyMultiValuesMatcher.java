package com.example.scaffold.frameworks.test.web;

public interface ResponseBodyMultiValuesMatcher {
    static ResponseBodyMultiValuesMatcher size(int value) {
        return new SizeBodyMatcher(value);
    }
    static ContainsExactlyMultiValuesMatcher containsExactly(Object... matchValues) {
        return new ContainsExactlyMultiValuesMatcher(matchValues);
    }
    static ResponseBodyMultiValuesMatcher contains(Object... matchValues) {
        return new ContainsMultiValuesMatcher(matchValues);
    }
    void match(Object[] values);
}
