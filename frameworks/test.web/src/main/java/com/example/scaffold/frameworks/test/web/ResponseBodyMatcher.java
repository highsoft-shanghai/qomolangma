package com.example.scaffold.frameworks.test.web;

public interface ResponseBodyMatcher<T> {
    /**
     * Delegated to assertj, see also {@link org.junit.jupiter.api.Assertions#assertEquals(Object, Object)}.
     */
    static ResponseBodyMatcher<Object> eq(Object value) {
        return new EqBodyMatcher(value);
    }
    /**
     * Delegated to assertj, see also {@link org.junit.jupiter.api.Assertions#assertNotEquals(Object, Object)}.
     */
    static ResponseBodyMatcher<Object> notEq(String value) {
        return new NotEqBodyMatcher(value);
    }
    /**
     * Delegated to assertj, see also {@link org.assertj.core.api.AbstractCharSequenceAssert#isNotNull()}.
     */
    static ResponseBodyMatcher<Object> isNotNull() {
        return new NotNullBodyMatcher();
    }
    /**
     * Delegated to assertj, see also {@link org.assertj.core.api.AbstractCharSequenceAssert#isNull()}.
     */
    static ResponseBodyMatcher<Object> isNull() {
        return new NullBodyMatcher();
    }
    /**
     * Delegated to assertj, see also {@link org.assertj.core.api.AbstractCharSequenceAssert#hasSize(int)}.
     */
    static ResponseBodyMatcher<String> hasSize(int size) {
        return new HasSizeBodyCastStringMatcher(size);
    }
    /**
     * Delegated to assertj, see also {@link org.assertj.core.api.AbstractCharSequenceAssert#isNotEmpty()}.
     */
    static ResponseBodyMatcher<String> isNotEmpty() {
        return new NotEmptyBodyCastStringMatcher();
    }
    /**
     * Delegated to assertj, see also {@link org.assertj.core.api.AbstractCharSequenceAssert#isEmpty()}.
     */
    static ResponseBodyMatcher<String> isEmpty() {
        return new EmptyBodyCastStringMatcher();
    }
    /**
     * Delegated to assertj, see also {@link org.assertj.core.api.AbstractCharSequenceAssert#isNullOrEmpty()}.
     */
    static ResponseBodyMatcher<String> isNullOrEmpty() {
        return new IsNullOrEmptyBodyCastStringMatcher();
    }
    static <T extends Comparable<T>> ResponseBodyMatcher<T> isGreaterThan(T num) {
        return new IsGreaterThanBodyCastIntegerMatcher<>(num);
    }
    static <T extends Comparable<T>> ResponseBodyMatcher<T> isGreaterThanOrEqualTo(T num) {
        return new IsGreaterThanOrEqualToBodyCastIntegerMatcher<>(num);
    }
    static <T extends Comparable<T>> ResponseBodyMatcher<T> isLessThan(T value) {
        return new IsLessThanBodyCastIntegerMatcher<>(value);
    }
    static <T extends Comparable<T>> ResponseBodyMatcher<T> isLessThanOrEqualTo(T value) {
        return new IsLessThanOrEqualToBodyCastIntegerMatcher<>(value);
    }
    static <T extends Number & Comparable<T>> ResponseBodyMatcher<T> isNegative() {
        return new IsNegativeBodyCastNumberMatcher<>();
    }
    static <T extends Number & Comparable<T>> ResponseBodyMatcher<T> isPositive() {
        return new IsPositiveBodyCastIntegerMatcher<>();
    }
    static <T extends Number & Comparable<T>> ResponseBodyMatcher<T> isNotNegative() {
        return new IsNotNegativeBodyCastIntegerMatcher<>();
    }
    static <T extends Number & Comparable<T>> ResponseBodyMatcher<T> isNotPositive() {
        return new IsNotPositiveBodyCastIntegerMatcher<>();
    }
    static <T extends Number & Comparable<T>> ResponseBodyMatcher<T> isZero() {
        return new IsZeroBodyCastIntegerMatcher<>();
    }
    static <T extends Number & Comparable<T>> ResponseBodyMatcher<T> isNotZero() {
        return new IsNotZeroBodyCastIntegerMatcher<>();
    }
    static <T extends Number & Comparable<T>> ResponseBodyMatcher<T> isEven() {
        return new IsEvenBodyCastIntegerMatcher<>();
    }
    static <T extends Number & Comparable<T>> ResponseBodyMatcher<T> isOdd() {
        return new IsOddBodyCastIntegerMatcher<>();
    }
    static <T extends Number & Comparable<T>> ResponseBodyMatcher<T> isOne() {
        return new IsOneBodyCastIntegerMatcher<>();
    }
    static ResponseBodyMatcher<Boolean> isTrue() {
        return new IsTrueBodyCastBooleanMatcher();
    }
    static ResponseBodyMatcher<Boolean> isFalse() {
        return new IsFalseBodyCastBooleanMatcher();
    }
    void match(T target);
}
