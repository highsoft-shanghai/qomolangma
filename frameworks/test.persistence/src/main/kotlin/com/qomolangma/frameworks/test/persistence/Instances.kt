package com.qomolangma.frameworks.test.persistence;

import com.qomolangma.frameworks.domain.core.Exceptions;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class Instances {

    private final List<Object> instances;

    public Instances(List<Object> instances) {
        this.instances = instances;
    }

    public void autoAssignPersistence() {
        this.instances.forEach(this::autoAssignPersistence);
    }

    private void autoAssignPersistence(Object instance) {
        Field[] fields = instance.getClass().getDeclaredFields();
        Arrays.stream(fields).forEach(field -> {
            if (!Persistences.exist(field.getType())) return;
            field.setAccessible(true);
            Exceptions.execute(() -> field.set(instance, Persistences.fetchByType(field.getType())));
        });
    }

}
