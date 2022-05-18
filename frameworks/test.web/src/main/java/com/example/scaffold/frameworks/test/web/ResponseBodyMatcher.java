package com.example.scaffold.frameworks.test.web;

public interface ResponseBodyMatcher {
    /**
     * Delegated to assertj, see also {@link org.junit.jupiter.api.Assertions#assertEquals(Object, Object)}.
     */
    static EqBodyMatcher eq(Object value) {
        return new EqBodyMatcher(value);
    }
    /**
     * Delegated to assertj, see also {@link org.assertj.core.api.AbstractCharSequenceAssert#hasSize(int)}.
     */
    static ResponseBodyMatcher hasSize(int size) {
        return new HasSizeBodyCastStringMatcher(size);
    }
    /**
     * Delegated to assertj, see also {@link org.assertj.core.api.AbstractCharSequenceAssert#isNotEmpty()}.
     */
    static ResponseBodyMatcher isNotEmpty() {
        return new NotEmptyBodyCastStringMatcher();
    }
    /**
     * Delegated to assertj, see also {@link org.junit.jupiter.api.Assertions#assertNotEquals(Object, Object)}.
     */
    static ResponseBodyMatcher notEq(String value) {
        return new NotEqBodyMatcher(value);
    }
    /**
     * Delegated to assertj, see also {@link org.assertj.core.api.AbstractCharSequenceAssert#isNotNull()}.
     */
    static ResponseBodyMatcher isNotNull() {
        return new NotNullBodyMatcher();
    }
    /**
     * Delegated to assertj, see also {@link org.assertj.core.api.AbstractCharSequenceAssert#isNull()}.
     */
    static NullBodyMatcher isNull() {
        return new NullBodyMatcher();
    }
    /**
     * Delegated to assertj, see also {@link org.assertj.core.api.AbstractCharSequenceAssert#isEmpty()}.
     */
    static ResponseBodyMatcher isEmpty() {
        return new EmptyBodyCastStringMatcher();
    }
    /**
     * Delegated to assertj, see also {@link org.assertj.core.api.AbstractCharSequenceAssert#isNullOrEmpty()}.
     */
    static ResponseBodyMatcher isNullOrEmpty() {
        return new IsNullOrEmptyBodyCastStringMatcher();
    }
    static ResponseBodyMatcher isGreaterThan(Integer num) {
        return new IsGreaterThanBodyCastIntegerMatcher(num);
    }
    static ResponseBodyMatcher isGreaterThanOrEqualTo(Integer num) {
        return new IsGreaterThanOrEqualToBodyCastIntegerMatcher(num);
    }
    static IsLessThanBodyCastIntegerMatcher isLessThan(Integer value) {
        return new IsLessThanBodyCastIntegerMatcher(value);
    }
    static IsLessThanOrEqualToBodyCastIntegerMatcher isLessThanOrEqualTo(Integer value) {
        return new IsLessThanOrEqualToBodyCastIntegerMatcher(value);
    }
    static IsNegativeBodyCastIntegerMatcher isNegative() {
        return new IsNegativeBodyCastIntegerMatcher();
    }
    static IsPositiveBodyCastIntegerMatcher isPositive() {
        return new IsPositiveBodyCastIntegerMatcher();
    }
    static IsNotNegativeBodyCastIntegerMatcher isNotNegative() {
        return new IsNotNegativeBodyCastIntegerMatcher();
    }
    static IsNotPositiveBodyCastIntegerMatcher isNotPositive() {
        return new IsNotPositiveBodyCastIntegerMatcher();
    }
    static IsZeroBodyCastIntegerMatcher isZero() {
        return new IsZeroBodyCastIntegerMatcher();
    }
    static IsNotZeroBodyCastIntegerMatcher isNotZero() {
        return new IsNotZeroBodyCastIntegerMatcher();
    }
    static IsEvenBodyCastIntegerMatcher isEven() {
        return new IsEvenBodyCastIntegerMatcher();
    }
    static IsOddBodyCastIntegerMatcher isOdd() {
        return new IsOddBodyCastIntegerMatcher();
    }
    void match(Object target);
}
