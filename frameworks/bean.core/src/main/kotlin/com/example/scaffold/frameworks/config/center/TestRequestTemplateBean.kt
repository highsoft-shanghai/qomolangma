package com.example.scaffold.frameworks.config.center

import com.example.scaffold.frameworks.test.web.TestRequestTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TestRequestTemplateBean {
    @Bean
    fun testRequestTemplate(): TestRequestTemplate {
        return TestRequestTemplate()
    }
}
