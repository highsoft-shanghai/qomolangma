package com.example.scaffold.frameworks.test.persistence;

import java.util.Map;
import java.util.function.Supplier;

@SuppressWarnings("all")
public final class Persistences {

    private Persistences() {
    }

    private static final Map<Class<?>, Supplier<Object>> PERSISTENCE_MAP = Map.of(
            TestClient.class, testClient()
    );

    public static <T> T fetchByType(Class<T> clazz) {
        return (T) PERSISTENCE_MAP.get(clazz).get();
    }

    public static boolean exist(Class<?> clazz) {
        return PERSISTENCE_MAP.containsKey(clazz);
    }

    private static Supplier<Object> testClient() {
        return () -> new TestClient();
    }

}
