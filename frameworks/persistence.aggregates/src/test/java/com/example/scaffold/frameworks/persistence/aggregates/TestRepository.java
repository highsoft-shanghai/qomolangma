package com.example.scaffold.frameworks.persistence.aggregates;

import org.springframework.data.repository.Repository;

import java.util.List;

@SuppressWarnings("all")
interface TestRepository extends Repository<TestData, String> {
    void deleteAll();
    void save(TestData data);
    void save(List<TestData> data);
    void deleteByName(String name);
    void deleteByNameAndId(String name, String id);
    void deleteByNameAndIdAndGender(String name, String id, String gender);
    TestData getByNoArgs();
    TestData findByName(String name);
    TestData findByNameAndId(String name, String id);
    TestData findByNameAndIdAndGender(String name, String id, String gender);
    List<TestData> findAll();
    List<TestData> findAllByName(String name);
    List<TestData> findAllByNameAndId(String name, String id);
    List<TestData> findAllByNameAndIdAndGender(String name, String id, String gender);
    int countAll();
    boolean existsByName(String name);
    boolean existsByNameAndId(String name, String id);
    boolean existsByNameAndIdAndGender(String name, String id, String gender);
}
