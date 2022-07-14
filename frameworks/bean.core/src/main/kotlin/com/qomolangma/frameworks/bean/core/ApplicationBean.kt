package com.qomolangma.frameworks.bean.core

import com.qomolangma.frameworks.security.core.ContextLoader
import com.qomolangma.frameworks.security.core.ContextProvider
import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

@Configuration
@EnableScheduling
@EnableAsync
class ApplicationBean {
    @Bean
    fun exceptionTranslator(messageSource: MessageSource?): ExceptionTranslator {
        return ExceptionTranslator(SpringMessageResolver(messageSource!!))
    }

    @Bean
    fun contextLoader(contextProvider: ContextProvider): ContextLoader {
        return ContextLoader(contextProvider)
    }

    @Bean
    fun corsFilter(): CorsFilter? {
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", buildConfig())
        return CorsFilter(source)
    }

    private fun buildConfig(): CorsConfiguration {
        val corsConfiguration = CorsConfiguration()
        corsConfiguration.addAllowedOrigin("*")
        corsConfiguration.addAllowedHeader("*")
        corsConfiguration.addAllowedMethod("*")
        return corsConfiguration
    }
}
