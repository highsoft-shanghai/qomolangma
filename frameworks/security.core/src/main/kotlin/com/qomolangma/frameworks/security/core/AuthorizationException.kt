package com.qomolangma.frameworks.security.core

import com.qomolangma.frameworks.domain.core.DomainException

class AuthorizationException(message: String?) : DomainException(message!!)
