package com.example.frameworks.domain.core;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GlobalIdGenerator {
    private static IdGenerator idGenerator = new UuidBasedIdGenerator();

    public static String nextId() {
        return idGenerator.next();
    }

    public static String nextReadableId() {
        return idGenerator.nextReadable();
    }

    static void reset(IdGenerator idGenerator) {
        GlobalIdGenerator.idGenerator = idGenerator;
    }
}
