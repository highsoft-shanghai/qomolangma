package com.example.scaffold.frameworks.persistence.aggregates;

import org.springframework.data.repository.Repository;

@SuppressWarnings("all")
interface TestRepository extends Repository<TestData, String> {
    void save(TestData data);
    void deleteByName(String name);
    void deleteByNameAndId(String name, String id);
    void deleteByNameAndIdAndGender(String name, String id, String gender);
    TestData findByName(String name);
    TestData findByNameAndId(String name, String id);
    TestData findByNameAndIdAndGender(String name, String id, String gender);
    boolean existsByName(String name);
    boolean existsByNameAndId(String name, String id);
    boolean existsByNameAndIdAndGender(String name, String id, String gender);
}
