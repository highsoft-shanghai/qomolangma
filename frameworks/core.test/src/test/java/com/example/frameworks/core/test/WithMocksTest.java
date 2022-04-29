package com.example.frameworks.core.test;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@WithMocks
public class WithMocksTest {
    private Person errorPerson;
    private @Mock Persons persons;
    private @Spy Persons spyPerson;
    private @Captor ArgumentCaptor<Person> captor;

    @BeforeEach
    void setUp() {
        errorPerson = new Person(null, null);
        doThrow(new RuntimeException("error, name cannot be null.")).when(persons).save(errorPerson);
    }

    @Test
    void should_be_able_to_mock_one_object_successfully() {
        assertThatThrownBy(() -> persons.save(errorPerson))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("error, name cannot be null.");
    }

    @Test
    void should_be_able_to_spy_one_real_object() {
        Person neil = new Person("Neil Wang", "webmaster@neilwang.wiki");
        spyPerson.save(neil);
        verify(spyPerson).save(neil);
    }

    @Test
    void should_be_able_to_use_captor_to_get_test_response() {
        new SavePersonUseCase(persons).execute();
        verify(persons, times(1)).save(captor.capture());
        assertEquals(captor.getValue().name, "Neil");
        assertEquals(captor.getValue().email.length(), 1);
        assertTrue(Integer.parseInt(captor.getValue().email) >= 0);
        assertTrue(Integer.parseInt(captor.getValue().email) < 5);
    }

    @AllArgsConstructor
    private static class SavePersonUseCase {
        private final Persons persons;

        private void execute() {
            persons.save(new Person("Neil", String.valueOf(new Random().nextInt(5))));
        }
    }

    @AllArgsConstructor
    private static class Person {
        private final String name;
        private final String email;
    }

    interface Persons {
        void save(Person person);
    }

    private static class TestPersons implements Persons {
        @Override
        public void save(Person person) {
        }
    }
}
