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
    /**
     * Verifies that the actual {@code CharSequence} is not empty, i.e., is not {@code null} and has a length of 1 or
     * more.
     * <p>
     * This assertion will succeed:
     * <pre><code class='java'> String bookName = &quot;A Game of Thrones&quot;
     * response.is(body(bookName, isNotEmpty()));</code></pre>
     * <p>
     * Whereas these assertions will fail:
     * <pre><code class='java'> String emptyString = &quot;&quot;
     * response.is(body(emptyString, isNotEmpty()));
     *
     * String nullString = null;
     * response.is(body(nullString, isNotEmpty()));</code></pre>
     * @return {@code this} assertion object.
     * @throws AssertionError if the actual {@code CharSequence} is empty (has a length of 0).
     */
    static ResponseBodyMatcher isNotEmpty() {
        return new NotEmptyBodyCastStringMatcher();
    }
    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are not equal.
     *
     * <p>Fails if both are {@code null}.
     * @see Object#equals(Object)
     */
    static ResponseBodyMatcher notEq(String value) {
        return new NotEqBodyMatcher(value);
    }
    /**
     * <em>Verifies</em> that the actual value is not null.
     * <p>
     * This assertion will succeed:
     * <pre><code class='java'>response.is(body("123", isNotNull()));</code></pre>
     * <p>
     * This assertion will succeed:
     * <pre><code class='java'>assertThat(null).isNotNull();</code></pre>
     * @return {@code this} assertion object.
     * @throws AssertionError if the actual {@code object} is {@code null}.
     */
    static ResponseBodyMatcher isNotNull() {
        return new NotNullBodyMatcher();
    }
    /**
     * <em>Assert</em> that {@code actual} is {@code null}.
     */
    static NullBodyMatcher isNull() {
        return new NullBodyMatcher();
    }
    /**
     * Verifies that the actual {@code CharSequence} is empty, i.e., it has a length of 0 and is not {@code null}.
     * <p>
     * If you want to accept a {@code null} value as well as a 0 length, use
     * {@link ResponseBodyMatcher#isNullOrEmpty()} instead.
     * <p>
     * This assertion will succeed:
     * <pre><code class='java'> String emptyString = &quot;&quot;
     * response.is(body(emptyString, isEmpty()));</code></pre>
     * <p>
     * Whereas these assertions will fail:
     * <pre><code class='java'> String nullString = null;
     * response.is(body(nullString, isEmpty()));
     * response.is(body("123", isEmpty()));
     * response.is(body("    ", isEmpty()));</code></pre>
     * @throws AssertionError if the actual {@code CharSequence} has a non-zero length or is null.
     */
    static ResponseBodyMatcher isEmpty() {
        return new EmptyBodyCastStringMatcher();
    }
    static ResponseBodyMatcher isNullOrEmpty() {
        return new IsNullOrEmptyBodyCastStringMatcher();
    }
    void match(Object target);
}
