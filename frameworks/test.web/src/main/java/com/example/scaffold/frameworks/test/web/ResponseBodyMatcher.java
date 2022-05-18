package com.example.scaffold.frameworks.test.web;

public interface ResponseBodyMatcher {
    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>If both are {@code null}, they are considered equal.
     * @see Object#equals(Object)
     */
    static EqBodyMatcher eq(Object value) {
        return new EqBodyMatcher(value);
    }
    /**
     * Verifies that the actual {@code CharSequence} has the expected length using the {@code length()} method.
     * <p>
     * This assertion will succeed:
     * <pre><code class='java'> String bookName = &quot;A Game of Thrones&quot;
     * response.is(body(bookName, hasSize(17)));</code></pre>
     * <p>
     * Whereas this assertion will fail:
     * <pre><code class='java'> String bookName = &quot;A Clash of Kings&quot;
     * response.is(body(bookName, hasSize(4)));</code></pre>
     * @param size the expected length of the actual {@code CharSequence}.
     * @return {@code this} assertion object.
     * @throws AssertionError if the actual length is not equal to the expected length.
     */
    static ResponseBodyMatcher hasSize(int size) {
        return new HasSizeBodyCastStringMatcher(size);
    }
    static ResponseBodyMatcher isNotEmpty() {
        return new NotEmptyBodyCastStringMatcher();
    }
    static ResponseBodyMatcher notEq(String value) {
        return new NotEqBodyMatcher(value);
    }
    static ResponseBodyMatcher isNotNull() {
        return new NotNullBodyMatcher();
    }
    static NullBodyMatcher isNull() {
        return new NullBodyMatcher();
    }
    static ResponseBodyMatcher isEmpty() {
        return new EmptyBodyCastStringMatcher();
    }
    void match(Object target);
}
