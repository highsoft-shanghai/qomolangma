package com.example.frameworks.core.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@WithMocks
public class WithMocksTest {
    private @Mock WithMocksUnitTest test;
    private @Spy WithMocksUnitTest test2 = new Impl("test");

    @BeforeEach
    void setUp() {
        given(test.evaluate()).willReturn("test");
    }

    @Test
    void should_be_able_to_mock_one_object_successfully() {
        assertEquals(test.evaluate(), "test");
        verify(test, times(1)).evaluate();
    }

    @Test
    void should_be_able_to_spy_one_object() {
        assertEquals(test2.evaluate(), "test");
        verify(test2, times(1)).evaluate();
    }

    interface WithMocksUnitTest {
        String evaluate();
    }

    static class Impl implements WithMocksUnitTest {
        private final String word;

        Impl(String word) {
            this.word = word;
        }

        @Override
        public String evaluate() {
            return word;
        }
    }
}
