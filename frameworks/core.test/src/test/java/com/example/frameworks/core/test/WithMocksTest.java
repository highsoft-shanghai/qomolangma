package com.example.frameworks.core.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@WithMocks
public class WithMocksTest {
    private @Mock WithMocksUnitTest test;

    @BeforeEach
    void setUp() {
        given(test.evaluate()).willReturn("test");
    }

    @Test
    void should_be_able_to_mock_one_object_successfully() {
        assertEquals(test.evaluate(), "test");
        verify(test, times(1)).evaluate();
    }

    interface WithMocksUnitTest {
        String evaluate();
    }
}
