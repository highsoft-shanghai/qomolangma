package com.example.frameworks.domain.core;

import com.example.frameworks.core.test.WithMocks;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@WithMocks
public class ExceptionsTest {
    private @Mock TestForExceptions mock;

    @Test
    void should_wrap_exception_for_void_functions() throws IOException {
        RuntimeException runtimeException = new RuntimeException();
        doThrow(runtimeException).when(mock).execute();
        assertThatThrownBy(() -> Exceptions.execute(mock::execute)).isInstanceOf(RuntimeException.class).isSameAs(runtimeException);
    }

    @Test
    void should_wrap_unchecked_exception_for_void_functions() throws IOException {
        doThrow(new IOException()).when(mock).execute();
        assertThatThrownBy(() -> Exceptions.execute(mock::execute)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void should_wrap_exception_for_functions_with_result() throws IOException {
        RuntimeException runtimeException = new RuntimeException();
        when(mock.evaluate()).thenThrow(runtimeException);
        assertThatThrownBy(() -> Exceptions.evaluate(mock::evaluate)).isInstanceOf(RuntimeException.class).isSameAs(runtimeException);
    }

    @Test
    void should_wrap_unchecked_exception_for_functions_with_result() throws IOException {
        when(mock.evaluate()).thenThrow(new IOException());
        assertThatThrownBy(() -> Exceptions.evaluate(mock::evaluate)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void should_be_able_to_execute_method_when_method_is_good() throws IOException {
        when(mock.evaluate()).thenReturn("");
        Exceptions.execute(mock::execute);
        verify(mock, times(1)).execute();
    }

    @Test
    void should_be_able_to_evaluate_method_when_method_is_good() throws IOException {
        when(mock.evaluate()).thenReturn("Test.");
        String evaluate = Exceptions.evaluate(mock::evaluate);
        verify(mock, times(1)).evaluate();
        assertEquals(evaluate, "Test.");
    }

    private interface TestForExceptions {
        void execute() throws IOException;
        String evaluate() throws IOException;
    }
}
