package com.example.scaffold.frameworks.test.web;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.restdocs.request.ParameterDescriptor;
import org.springframework.restdocs.request.RequestDocumentation;
import org.springframework.restdocs.snippet.Attributes;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConstrainedParameters {

    public static ParameterDescriptor parameterWithConstraints(String name, String type, String constraints) {
        return RequestDocumentation.parameterWithName(name).attributes(
            Attributes.key("constraints").value(constraints),
            Attributes.key("type").value(type)
        );
    }

}
