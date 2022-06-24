package com.qomolangma.frameworks.test.web

abstract class ApiTest : IntegrationTest() {
    abstract fun document(): Documentation
}
