package com.qomolangma.frameworks.test.web

abstract class ApiTest : IntegrationTest() {
    abstract fun documentation(): Documentation?
}
