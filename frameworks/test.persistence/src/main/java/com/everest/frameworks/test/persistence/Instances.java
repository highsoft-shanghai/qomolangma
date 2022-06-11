package com.everest.frameworks.test.persistence;

import com.everest.frameworks.domain.core.Exceptions;
import org.jetbrains.annotations.NotNull;

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
        Class<?> instanceClass = instance.getClass();
        Field[] fields = instanceClass.getDeclaredFields();
        Arrays.stream(fields).forEach(field -> {
            if (!field.isAnnotationPresent(Persistence.class)) return;
            field.setAccessible(true);
            Exceptions.execute(() -> field.set(instance, Persistences.fetchByType(type(field))));
        });
    }

    @NotNull
    protected Class<?> type(Field field) {
        Class<?> type = field.getType();
        if (!Persistences.exist(type)) throw new PersistenceException("Error! The type is not register in Persistence:" + type.getName()
                + ". You need to check if the type is valid. If it is a new persistence template, you can add it to Persistence in " +
                "frameworks.test.persistence.");
        return type;
    }

}
