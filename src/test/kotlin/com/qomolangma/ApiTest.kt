package com.qomolangma

import com.qomolangma.frameworks.test.web.Documentation

abstract class ApiTest : IntegrationTest() {
    abstract fun document(): Documentation
}
