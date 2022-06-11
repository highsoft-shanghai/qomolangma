package com.example.scaffold.frameworks.test.web

import lombok.AccessLevel
import lombok.NoArgsConstructor
import org.springframework.restdocs.payload.FieldDescriptor
import org.springframework.restdocs.payload.PayloadDocumentation
import org.springframework.restdocs.snippet.Attributes

@NoArgsConstructor(access = AccessLevel.PRIVATE)
object ConstrainedFields {
    @JvmStatic
    fun constrainedFieldWithPath(path: String?, constraints: String?): FieldDescriptor {
        return PayloadDocumentation.fieldWithPath(path).attributes(
            Attributes.key("constraints").value(constraints)
        )
    }
}
