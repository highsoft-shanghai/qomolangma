package com.qomolangma.iam.gateways

import com.qomolangma.frameworks.security.core.ContextProvider
import com.qomolangma.iam.domain.AccessTokenContextProvider
import com.qomolangma.iam.domain.Users
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class IamConfiguration {
    @Bean
    fun contextProvider(accessTokenRepository: Users): ContextProvider {
        return AccessTokenContextProvider(accessTokenRepository)
    }
}
