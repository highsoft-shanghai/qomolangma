package com.example.scaffold.frameworks.persistence.aggregates;

import com.example.frameworks.core.test.WithMocks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.when;

@WithMocks
public class AggregatesTest {
    private @Mock TestRepository testRepository;
    private TestAggregates aggregates;

    @BeforeEach
    void setUp() {
        when(testRepository.findByName("test")).thenReturn(new TestData(new TestAggregate("test")));
        when(testRepository.findByNameAndId("test", "id")).thenReturn(new TestData(new TestAggregate("test")));
        when(testRepository.findByNameAndIdAndGender("test", "id", "gender")).thenReturn(new TestData(new TestAggregate("test")));
        when(testRepository.existsByName("test")).thenReturn(true);
        when(testRepository.existsByNameAndId("test", "id")).thenReturn(true);
        when(testRepository.existsByNameAndIdAndGender("test", "id", "gender")).thenReturn(true);
        when(testRepository.findByNameAndIdAndGender("test null", "id", "gender")).thenReturn(null);
        aggregates = new MongoTestAggregates(testRepository);
    }

    @Test
    void should_be_able_to_accept_one_aggregate_consumer() {
        aggregates.add(new TestAggregate(""));
        then(testRepository).should(only()).save(new TestData(new TestAggregate("")));
    }

    @Test
    void should_be_able_to_accept_one_param_consumer() {
        aggregates.clearByName("test");
        then(testRepository).should(only()).deleteByName("test");
    }

    @Test
    void should_be_able_to_apply_one_aggregate_function() {
        TestAggregate aggregate = aggregates.getByName("test");
        assertEquals(aggregate.name(), "test");
    }

    @Test
    void should_be_able_to_apply_one_param_function() {
        assertTrue(aggregates.containsByName("test"));
    }

    @Test
    void should_be_able_to_accept_two_param_consumer() {
        aggregates.clearByNameAndId("name", "id");
        then(testRepository).should(only()).deleteByNameAndId("name", "id");
    }

    @Test
    void should_be_able_to_apply_two_aggregates_function() {
        TestAggregate aggregate = aggregates.getByNameAndId("test", "id");
        assertEquals(aggregate.name(), "test");
    }

    @Test
    void should_be_able_to_apply_two_params_function() {
        assertTrue(aggregates.containsByNameAndId("test", "id"));
    }

    @Test
    void should_be_able_to_accept_three_param_consumer() {
        aggregates.clearByNameAndIdAndGender("name", "id", "gender");
        then(testRepository).should(only()).deleteByNameAndIdAndGender("name", "id", "gender");
    }

    @Test
    void should_be_able_to_apply_three_aggregates_function() {
        TestAggregate aggregate = aggregates.getByNameAndIdAndGender("test", "id", "gender");
        assertEquals(aggregate.name(), "test");
    }

    @Test
    void should_be_able_to_apply_three_params_function() {
        assertTrue(aggregates.containsByNameAndIdAndGender("test", "id", "gender"));
    }

    @Test
    void should_throw_exception_when_query_null() {
        assertThrows(RuntimeException.class, () -> aggregates.getByNameAndIdAndGender("test null", "id", "gender"),
                "error.can-not-get-aggregate");
    }
}
