package com.example.frameworks.domain.core;

import com.fasterxml.uuid.Generators;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class UuidBasedIdGenerator implements IdGenerator {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSSSSSS");
    private static final long A = 10000000;
    private static final long B = 12219292800L;
    private static final long C = 1000000;
    private static final long D = 100;
    private static final int E = 8;

    @Override
    public String next() {
        return UUID.randomUUID().toString().toLowerCase().replace("-", "");
    }

    @Override
    public String nextReadable() {
        UUID uuid = Generators.timeBasedGenerator().generate();
        return formatUuidTimestamp(uuid.timestamp());
    }

    private String formatUuidTimestamp(long timestamp) {
        return FORMATTER.format(Instant.ofEpochSecond(timestamp / A - B, timestamp % C * D).atZone(ZoneOffset.ofHours(E)));
    }

}
