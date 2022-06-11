package com.example.scaffold.frameworks.test.web;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static com.example.scaffold.frameworks.test.web.ApiDocUtils.pagedRequestParameters;
import static com.example.scaffold.frameworks.test.web.ApiDocUtils.pagedResponseFields;
import static com.example.scaffold.frameworks.test.web.ConstrainedFields.constrainedFieldWithPath;
import static com.example.scaffold.frameworks.test.web.ConstrainedParameters.parameterWithConstraints;
import static com.example.scaffold.frameworks.test.web.Documentation.doc;
import static com.example.scaffold.frameworks.test.web.PathVariables.variables;
import static com.example.scaffold.frameworks.test.web.RequestParameters.parameters;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;

public class DocumentationTest extends IntegrationTest {

    @Test
    void should_be_able_to_generate_document_header() {
        ValidatableResponse response = get("/web-test/api-header/{id}", variables(Map.of("id", "5")), doc("api-header"));
        response.statusCode(is(200));
        assertThat(Files.exists(Paths.get("build/generated-snippets/api-header/api-header.adoc"))).isTrue();
        assertThat(Files.exists(Paths.get("build/generated-snippets/api-header/api.adoc"))).isTrue();
    }

    @Test
    void should_be_able_to_generate_document_header_without_path_variables() {
        ValidatableResponse response = get("/web-test/api-header", doc("api-header-without-path-parameters"));
        response.statusCode(is(200));
        assertThat(Files.exists(Paths.get("build/generated-snippets/api-header-without-path-parameters/api-header.adoc"))).isTrue();
    }

    @Test
    void should_be_able_to_document_path_variables_and_constrained_fields() {
        ValidatableResponse response = post("/web-test/document-constrained-fields/{id}", variables(Map.of("id", "5")), Map.of("name", "John"), doc("constrained-fields",
                requestFields(
                        constrainedFieldWithPath("name", "Can NOT be empty").description("Name for new user")
                ))
        );
        response.statusCode(is(200));
        assertThat(Files.exists(Paths.get("build/generated-snippets/constrained-fields/request-fields.adoc"))).isTrue();
    }

    @Test
    void should_be_able_to_document_constrained_parameters() {
        RequestParameters parameters = parameters(Map.of("q", "john", "size", 10, "page", 0));
        ValidatableResponse response = get("/web-test/document-constrained-parameters", parameters, doc("constrained-parameters",
                pagedRequestParameters(
                        parameterWithConstraints("q", "String", "Can NOT be empty").description("Keyword for searching")
                ))
        );
        response.statusCode(is(200));
        assertThat(Files.exists(Paths.get("build/generated-snippets/constrained-parameters/request-parameters.adoc"))).isTrue();
    }

    @Test
    void should_be_able_to_document_paged_responses() {
        ValidatableResponse response = get("/web-test/document-paged-response", parameters(Map.of()), doc("paged-response",
                pagedResponseFields(
                        fieldWithPath("content[].name").description("User name")
                ))
        );
        response.statusCode(is(200));
        assertThat(Files.exists(Paths.get("build/generated-snippets/paged-response/response-fields.adoc"))).isTrue();
    }

}
