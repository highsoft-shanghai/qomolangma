package com.example.frameworks.domain.core;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ExceptionsTest {
    @Test
    void should_wrap_exception_for_void_functions() throws IOException {
        TestForExceptions mock = mock(TestForExceptions.class);
        RuntimeException runtimeException = new RuntimeException();
        doThrow(runtimeException).when(mock).execute();
        Throwable exception = catchThrowable(() -> Exceptions.execute(mock::execute));
        assertThat(exception).isInstanceOf(RuntimeException.class).isSameAs(runtimeException);
    }

    @Test
    void should_wrap_unchecked_exception_for_void_functions() throws IOException {
        TestForExceptions mock = mock(TestForExceptions.class);
        doThrow(new IOException()).when(mock).execute();
        Throwable exception = catchThrowable(() -> Exceptions.execute(mock::execute));
        assertThat(exception).isInstanceOf(RuntimeException.class);
    }

    @Test
    void should_wrap_exception_for_functions_with_result() throws IOException {
        TestForExceptions mock = mock(TestForExceptions.class);
        RuntimeException runtimeException = new RuntimeException();
        when(mock.evaluate()).thenThrow(runtimeException);
        Throwable exception = catchThrowable(() -> Exceptions.evaluate(mock::evaluate));
        assertThat(exception).isInstanceOf(RuntimeException.class).isSameAs(runtimeException);
    }

    @Test
    void should_wrap_unchecked_exception_for_functions_with_result() throws IOException {
        TestForExceptions mock = mock(TestForExceptions.class);
        when(mock.evaluate()).thenThrow(new IOException());
        Throwable exception = catchThrowable(() -> Exceptions.evaluate(mock::evaluate));
        assertThat(exception).isInstanceOf(RuntimeException.class);
    }

    @Test
    void should_be_able_to_execute_method_when_method_is_good() throws IOException {
        TestForExceptions mock = mock(TestForExceptions.class);
        Exceptions.execute(mock::execute);
        verify(mock, times(1)).execute();
    }

    @Test
    void should_be_able_to_evaluate_method_when_method_is_good() throws IOException {
        TestForExceptions mock = mock(TestForExceptions.class);
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
