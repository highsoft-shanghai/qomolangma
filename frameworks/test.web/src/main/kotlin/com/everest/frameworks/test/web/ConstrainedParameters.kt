package com.everest.frameworks.test.web

import lombok.AccessLevel
import lombok.NoArgsConstructor
import org.springframework.restdocs.request.ParameterDescriptor
import org.springframework.restdocs.request.RequestDocumentation
import org.springframework.restdocs.snippet.Attributes

@NoArgsConstructor(access = AccessLevel.PRIVATE)
object ConstrainedParameters {
    @JvmStatic
    fun parameterWithConstraints(name: String?, type: String?, constraints: String?): ParameterDescriptor {
        return RequestDocumentation.parameterWithName(name).attributes(
            Attributes.key("constraints").value(constraints),
            Attributes.key("type").value(type)
        )
    }
}
