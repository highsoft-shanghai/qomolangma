package com.qomolangma.frameworks.test.web

import com.qomolangma.frameworks.test.web.ApiDocUtils.pagedRequestParameters
import com.qomolangma.frameworks.test.web.ApiDocUtils.pagedResponseFields
import com.qomolangma.frameworks.test.web.ConstrainedFields.constrainedFieldWithPath
import com.qomolangma.frameworks.test.web.ConstrainedParameters.parameterWithConstraints
import com.qomolangma.frameworks.test.web.PathVariables.Companion.variables
import com.qomolangma.frameworks.test.web.RequestParameters.Companion.parameters
import org.assertj.core.api.Assertions.assertThat
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.springframework.restdocs.payload.PayloadDocumentation
import java.nio.file.Files
import java.nio.file.Paths

class DocumentationTest : IntegrationTest() {
    @Test
    fun should_be_able_to_generate_document_header() {
        val response =
            get("/web-test/api-header/{id}", variables(mapOf(Pair("id", "5"))), Documentation.doc("api-header"))
        response.statusCode(Matchers.`is`(200))
        assertThat(Files.exists(Paths.get("build/generated-snippets/api-header/api-header.adoc"))).isTrue
        assertThat(Files.exists(Paths.get("build/generated-snippets/api-header/api.adoc"))).isTrue
    }

    @Test
    fun should_be_able_to_generate_document_header_without_path_variables() {
        val response = get("/web-test/api-header", Documentation.doc("api-header-without-path-parameters"))
        response.statusCode(Matchers.`is`(200))
        assertThat(Files.exists(Paths.get("build/generated-snippets/api-header-without-path-parameters/api-header.adoc"))).isTrue
    }

    @Test
    fun should_be_able_to_document_path_variables_and_constrained_fields() {
        val response = post(
            "/web-test/document-constrained-fields/{id}",
            variables(mapOf(Pair("id", "5"))),
            mapOf(Pair("name", "John")),
            Documentation.doc(
                "constrained-fields",
                PayloadDocumentation.requestFields(
                    constrainedFieldWithPath("name", "Can NOT be empty").description("Name for new user")
                )
            )
        )
        response.statusCode(Matchers.`is`(200))
        assertThat(Files.exists(Paths.get("build/generated-snippets/constrained-fields/request-fields.adoc"))).isTrue
    }

    @Test
    fun should_be_able_to_document_constrained_parameters() {
        val parameters = parameters(mapOf(Pair("q", "john"), Pair("size", 10), Pair("page", 0)))
        val response = get(
            "/web-test/document-constrained-parameters", parameters, Documentation.doc(
                "constrained-parameters",
                pagedRequestParameters(
                    parameterWithConstraints("q", "String", "Can NOT be empty").description("Keyword for searching")
                )
            )
        )
        response.statusCode(Matchers.`is`(200))
        assertThat(Files.exists(Paths.get("build/generated-snippets/constrained-parameters/request-parameters.adoc"))).isTrue
    }

    @Test
    fun should_be_able_to_document_paged_responses() {
        val response = get(
            "/web-test/document-paged-response", parameters(mapOf<String, Any?>()), Documentation.doc(
                "paged-response",
                pagedResponseFields(
                    PayloadDocumentation.fieldWithPath("content[].name").description("User name")
                )
            )
        )
        response.statusCode(Matchers.`is`(200))
        assertThat(Files.exists(Paths.get("build/generated-snippets/paged-response/response-fields.adoc"))).isTrue
    }
}
