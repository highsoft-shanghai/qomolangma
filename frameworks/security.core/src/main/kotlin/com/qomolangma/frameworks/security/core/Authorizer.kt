package com.qomolangma.frameworks.security.core

class Authorizer {
    fun authorize(vararg requiredAuthorities: String?) {
        GlobalSecurityContext.securityContext().authorize(RequiredAuthorities.of(*requiredAuthorities))
    }
}
