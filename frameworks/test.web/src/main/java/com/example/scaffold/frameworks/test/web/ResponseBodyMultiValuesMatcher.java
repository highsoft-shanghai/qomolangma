package com.example.scaffold.frameworks.test.web;

public interface ResponseBodyMultiValuesMatcher {
    /**
     * Verifies that the number of values in the actual group is equal to the given one.
     * <p>
     * This assertion will succeed:
     * <pre><code class='java'> assertThat(new String[] { "a", "b" }).hasSize(2);</code></pre>
     * <pre><code class='java'> assertThat(Arrays.asList(1, 2, 3)).hasSize(3);</code></pre>
     * <p>
     * Whereas this assertion will fail:
     * <pre><code class='java'> assertThat(new ArrayList()).hasSize(1);</code></pre>
     * <pre><code class='java'> assertThat(new int[] { 1, 2, 3 }).hasSize(2);</code></pre>
     * @param value the expected length of the actual group.
     * @return {@code this} assertion object.
     * @throws AssertionError if the number of values of the actual group is not equal to the given one.
     */
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
