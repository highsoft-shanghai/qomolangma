package com.qomolangma.frameworks.test.web;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.Filter;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.restdocs.ManualRestDocumentation;
import org.springframework.restdocs.restassured3.RestAssuredOperationPreprocessorsConfigurer;

import javax.annotation.Nullable;
import java.lang.reflect.Method;

import static com.qomolangma.frameworks.test.web.ApiDocUtils.apiHeader;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.document;
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.documentationConfiguration;

@AutoConfigureRestDocs
public class Rest {

    private final ManualRestDocumentation documentation = new ManualRestDocumentation();
    private RequestSpecification spec;
    private @Value("${local.server.port}") int port;

    protected ValidatableResponse get(String path) {
        return given(null).when().get(path).then();
    }

    protected ValidatableResponse get(String path, Documentation doc) {
        return given(doc).when().get(path).then();
    }

    protected ValidatableResponse get(String path, RequestParameters parameters, Documentation doc) {
        return given(doc).params(parameters.asMap()).when().get(path).then();
    }

    protected ValidatableResponse get(String path, PathVariables variables, Documentation doc) {
        return given(doc).pathParams(variables.asMap()).when().get(path).then();
    }

    protected ValidatableResponse post(String path, PathVariables variables, Object body, Documentation doc) {
        return given(doc).pathParams(variables.asMap()).body(body).contentType(ContentType.JSON).when().post(path).then();
    }

    protected RequestSpecification given(@Nullable Documentation doc) {
        return RestAssured.given(spec).port(port).accept(ContentType.JSON).contentType(ContentType.JSON).filter(docFilter(doc));
    }

    @BeforeEach
    void setupRestDoc(TestInfo info) {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        this.spec = builder.addFilter(documentationFilter()).build();
        this.documentation.beforeTest(getClass(), info.getTestMethod().map(Method::getName).orElse(""));
    }

    @AfterEach
    void tearDownRestDoc() {
        this.documentation.afterTest();
    }

    private Filter docFilter(Documentation doc) {
        if (doc == null) return EmptyFilter.INSTANCE;
        return document(doc.identifier(), ArrayUtils.addAll(doc.snippets(), apiHeader(false), new ApiSnippet()));
    }

    private RestAssuredOperationPreprocessorsConfigurer documentationFilter() {
        return documentationConfiguration(this.documentation).operationPreprocessors().withRequestDefaults(prettyPrint()).withResponseDefaults(prettyPrint());
    }

}
