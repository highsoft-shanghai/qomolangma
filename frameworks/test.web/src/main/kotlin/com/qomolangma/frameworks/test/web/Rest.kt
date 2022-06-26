package com.qomolangma.frameworks.test.web

import com.qomolangma.frameworks.test.web.ApiDocUtils.apiHeader
import io.restassured.RestAssured
import io.restassured.builder.RequestSpecBuilder
import io.restassured.filter.Filter
import io.restassured.http.ContentType
import io.restassured.response.ValidatableResponse
import io.restassured.specification.RequestSpecification
import org.apache.commons.lang3.ArrayUtils
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInfo
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.restdocs.ManualRestDocumentation
import org.springframework.restdocs.operation.preprocess.Preprocessors
import org.springframework.restdocs.restassured3.RestAssuredOperationPreprocessorsConfigurer
import org.springframework.restdocs.restassured3.RestAssuredRestDocumentation
import java.lang.reflect.Method

@AutoConfigureRestDocs
open class Rest {
    private val documentation = ManualRestDocumentation()
    private var spec: RequestSpecification? = null

    @Value("\${local.server.port}")
    private val port = 0
    protected operator fun get(path: String?): ValidatableResponse {
        return given(null).`when`()[path].then()
    }

    protected operator fun get(path: String?, doc: Documentation?): ValidatableResponse {
        return given(doc).`when`()[path].then()
    }

    protected operator fun get(path: String?, parameters: RequestParameters, doc: Documentation?): ValidatableResponse {
        return given(doc).params(parameters.asMap()).`when`()[path].then()
    }

    protected operator fun get(path: String?, variables: PathVariables, doc: Documentation?): ValidatableResponse {
        return given(doc).pathParams(variables.asMap()).`when`()[path].then()
    }

    protected fun post(path: String?, variables: PathVariables, body: Any?, doc: Documentation?): ValidatableResponse {
        return given(doc).pathParams(variables.asMap()).body(body).contentType(ContentType.JSON).`when`().post(path)
            .then()
    }

    protected fun given(doc: Documentation?): RequestSpecification {
        return RestAssured.given(spec).port(port).accept(ContentType.JSON).contentType(ContentType.JSON)
            .filter(docFilter(doc))
    }

    @BeforeEach
    fun setupRestDoc(info: TestInfo) {
        val builder = RequestSpecBuilder()
        spec = builder.addFilter(documentationFilter()).build()
        documentation.beforeTest(javaClass, info.testMethod.map { obj: Method -> obj.name }
            .orElse(""))
    }

    @AfterEach
    fun tearDownRestDoc() {
        documentation.afterTest()
    }

    private fun docFilter(doc: Documentation?): Filter {
        return if (doc == null) EmptyFilter.INSTANCE else RestAssuredRestDocumentation.document(
            doc.identifier(),
            *ArrayUtils.addAll(doc.snippets(), apiHeader(false), ApiSnippet())
        )
    }

    private fun documentationFilter(): RestAssuredOperationPreprocessorsConfigurer {
        return RestAssuredRestDocumentation.documentationConfiguration(documentation).operationPreprocessors()
            .withRequestDefaults(Preprocessors.prettyPrint()).withResponseDefaults(Preprocessors.prettyPrint())
    }
}
