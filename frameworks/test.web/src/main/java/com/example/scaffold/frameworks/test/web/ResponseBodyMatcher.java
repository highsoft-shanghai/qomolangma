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
    static ResponseBodyMatcher isLessThan(Integer value) {
        return new IsLessThanBodyCastIntegerMatcher(value);
    }
    static ResponseBodyMatcher isLessThanOrEqualTo(Integer value) {
        return new IsLessThanOrEqualToBodyCastIntegerMatcher(value);
    }
    static ResponseBodyMatcher isNegative() {
        return new IsNegativeBodyCastIntegerMatcher();
    }
    static ResponseBodyMatcher isPositive() {
        return new IsPositiveBodyCastIntegerMatcher();
    }
    static ResponseBodyMatcher isNotNegative() {
        return new IsNotNegativeBodyCastIntegerMatcher();
    }
    static ResponseBodyMatcher isNotPositive() {
        return new IsNotPositiveBodyCastIntegerMatcher();
    }
    static ResponseBodyMatcher isZero() {
        return new IsZeroBodyCastIntegerMatcher();
    }
    static ResponseBodyMatcher isNotZero() {
        return new IsNotZeroBodyCastIntegerMatcher();
    }
    static ResponseBodyMatcher isEven() {
        return new IsEvenBodyCastIntegerMatcher();
    }
    static ResponseBodyMatcher isOdd() {
        return new IsOddBodyCastIntegerMatcher();
    }
    static ResponseBodyMatcher isOne() {
        return new IsOneBodyCastIntegerMatcher();
    }
    static ResponseBodyMatcher isTrue() {
        return new IsTrueBodyCastBooleanMatcher();
    }
    static ResponseBodyMatcher isFalse() {
        return new IsFalseBodyCastBooleanMatcher();
    }
    void match(Object target);
}
