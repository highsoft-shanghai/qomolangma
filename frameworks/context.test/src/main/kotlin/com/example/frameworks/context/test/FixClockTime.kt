package com.example.frameworks.context.test;

import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(FixClockTimeExtension.class)
public @interface FixClockTime {
    String value();
}
