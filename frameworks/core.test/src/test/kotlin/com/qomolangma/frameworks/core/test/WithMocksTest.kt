package com.qomolangma.frameworks.core.test

import lombok.AllArgsConstructor
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.*
import java.util.*

@WithMocks
class WithMocksTest {
    private var errorPerson: Person? = null

    @Mock
    private val persons: Persons? = null

    @Spy
    private val spyPerson: Persons? = null

    @Captor
    private val captor: ArgumentCaptor<Person>? = null

    @BeforeEach
    fun setUp() {
        errorPerson = Person(null, null)
        Mockito.doThrow(RuntimeException("error, name cannot be null.")).`when`(persons)?.add(errorPerson)
    }

    @Test
    fun should_be_able_to_mock_one_object_successfully() {
        Assertions.assertThatThrownBy { persons!!.add(errorPerson) }
            .isInstanceOf(RuntimeException::class.java)
            .hasMessage("error, name cannot be null.")
    }

    @Test
    fun should_be_able_to_spy_one_real_object() {
        val neil = Person("Neil Wang", "webmaster@neilwang.wiki")
        spyPerson!!.add(neil)
        BDDMockito.then(spyPerson).should(Mockito.only()).add(neil)
    }

    @Test
    fun should_be_able_to_use_captor_to_get_test_response() {
        SavePersonUseCase(persons).execute()
        BDDMockito.then(persons).should(Mockito.only())?.add(captor!!.capture())
        org.junit.jupiter.api.Assertions.assertEquals("Neil", captor?.value?.name)
        org.junit.jupiter.api.Assertions.assertEquals(1, captor?.value?.email!!.length)
        assertThat(captor.value?.email!!.toInt()).isNotNegative
        assertThat(captor.value?.email!!.toInt()).isLessThan(5)
    }

    @AllArgsConstructor
    private class SavePersonUseCase(private val persons: Persons?) {
        fun execute() {
            this.persons!!.add(Person("Neil", Random().nextInt(5).toString()))
        }
    }

    class Person(val name: String?, val email: String?) {
    }

    internal interface Persons {
        fun add(person: Person?)
    }
}
