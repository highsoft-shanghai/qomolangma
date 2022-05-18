package com.example.scaffold.frameworks.test.web;

public interface ResponseBodyMultiValuesMatcher {
    /**
     * Delegated to assertj, see also {@link org.assertj.core.api.AbstractObjectArrayAssert#hasSize(int)}
     */
    static ResponseBodyMultiValuesMatcher size(int value) {
        return new SizeBodyMatcher(value);
    }
    /**
     * Delegated to assertj, see also {@link org.assertj.core.api.AbstractObjectArrayAssert#containsExactly(Object[])}
     */
    static ContainsExactlyMultiValuesMatcher containsExactly(Object... matchValues) {
        return new ContainsExactlyMultiValuesMatcher(matchValues);
    }
    /**
     * Delegated to assertj, see also {@link org.assertj.core.api.AbstractObjectArrayAssert#contains(Object[])}
     */
    static ResponseBodyMultiValuesMatcher contains(Object... matchValues) {
        return new ContainsMultiValuesMatcher(matchValues);
    }
    void match(Object[] values);
}
