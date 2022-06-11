package com.example.scaffold.frameworks.test.web;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.restdocs.snippet.Attributes;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConstrainedFields {

    public static FieldDescriptor constrainedFieldWithPath(String path, String constraints) {
        return PayloadDocumentation.fieldWithPath(path).attributes(
            Attributes.key("constraints").value(constraints)
        );
    }

}
