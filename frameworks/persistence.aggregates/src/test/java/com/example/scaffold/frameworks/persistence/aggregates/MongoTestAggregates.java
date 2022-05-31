package com.example.scaffold.frameworks.persistence.aggregates;

import java.util.List;

final class MongoTestAggregates implements TestAggregates {

    private final Aggregates<TestAggregate, TestData, TestRepository, String> aggregates;

    public MongoTestAggregates(TestRepository repository) {
        this.aggregates = new Aggregates<>(repository, TestData::new, TestData::asDomain);
    }

    @Override
    public void clear() {
        aggregates.accept(TestRepository::deleteAll);
    }

    @Override
    public void add(TestAggregate aggregate) {
        aggregates.acceptByAggregate(TestRepository::save, aggregate);
    }

    @Override
    public void add(List<TestAggregate> aggregate) {
        aggregates.acceptByAggregates(TestRepository::save, aggregate);
    }

    @Override
    public void clearByName(String name) {
        aggregates.accept(TestRepository::deleteByName, name);
    }

    @Override
    public void clearByNameAndId(String name, String id) {
        aggregates.accept(TestRepository::deleteByNameAndId, name, id);
    }

    @Override
    public void clearByNameAndIdAndGender(String name, String id, String gender) {
        aggregates.accept(TestRepository::deleteByNameAndIdAndGender, name, id, gender);
    }

    @Override
    public TestAggregate getByNoArgs() {
        return aggregates.applyAsAggregate(TestRepository::getByNoArgs);
    }

    @Override
    public TestAggregate getByName(String name) {
        return aggregates.applyAsAggregate(TestRepository::findByName, name);
    }

    @Override
    public TestAggregate getByNameAndId(String name, String id) {
        return aggregates.applyAsAggregate(TestRepository::findByNameAndId, name, id);
    }

    @Override
    public TestAggregate getByNameAndIdAndGender(String name, String id, String gender) {
        return aggregates.applyAsAggregate(TestRepository::findByNameAndIdAndGender, name, id, gender);
    }

    @Override
    public List<TestAggregate> get() {
        return aggregates.applyAsAggregates(TestRepository::findAll);
    }

    @Override
    public List<TestAggregate> get(String name) {
        return aggregates.applyAsAggregates(TestRepository::findAllByName, name);
    }

    @Override
    public List<TestAggregate> get(String name, String id) {
        return aggregates.applyAsAggregates(TestRepository::findAllByNameAndId, name, id);
    }

    @Override
    public List<TestAggregate> get(String name, String id, String gender) {
        return aggregates.applyAsAggregates(TestRepository::findAllByNameAndIdAndGender, name, id, gender);
    }

    @Override
    public int size() {
        return aggregates.apply(TestRepository::countAll);
    }

    @Override
    public boolean containsByName(String name) {
        return aggregates.apply(TestRepository::existsByName, name);
    }

    @Override
    public boolean containsByNameAndId(String name, String id) {
        return aggregates.apply(TestRepository::existsByNameAndId, name, id);
    }

    @Override
    public boolean containsByNameAndIdAndGender(String name, String id, String gender) {
        return aggregates.apply(TestRepository::existsByNameAndIdAndGender, name, id, gender);
    }

}
